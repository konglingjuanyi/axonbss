package org.mri.processors;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.reference.CtFieldReference;
import spoon.reflect.reference.CtTypeReference;
import spoon.support.QueueProcessingManager;
import spoon.support.reflect.declaration.CtFieldImpl;
import spoon.support.reflect.declaration.CtTypeImpl;
import spoon.support.reflect.reference.CtTypeReferenceImpl;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SubAggregatesFinder {
    public static final String AXON_AGGREGATE_IDENTIFIER_ANNOTATION =
            "@org.axonframework.eventsourcing.annotation.AggregateIdentifier";
    private List<CtTypeReference> aggregates = new ArrayList<>();

    private class Processor extends AbstractProcessor<CtTypeImpl> {

        @Override
        public void process(CtTypeImpl aClass) {
        	CtTypeReference aRef=aClass.getReference();
            if (!aggregates.contains(aRef)){
            	if (aggregates.contains(aRef.getSuperclass())){
            		aggregates.add(aRef);
            	}
            }
        } 

    }
    public List<CtTypeReference> all(List<CtTypeReference> aggregates,QueueProcessingManager queueProcessingManager) {
    	this.aggregates=aggregates;
    	queueProcessingManager.addProcessor(new Processor());
        queueProcessingManager.process();
        return aggregates;
    }
}
