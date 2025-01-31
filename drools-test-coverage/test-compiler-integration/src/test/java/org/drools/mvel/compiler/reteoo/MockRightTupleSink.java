/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.drools.mvel.compiler.reteoo;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.drools.core.common.NetworkNode;
import org.drools.core.common.ReteEvaluator;
import org.drools.core.common.RuleBasePartitionId;
import org.drools.core.reteoo.NodeTypeEnums;
import org.drools.core.reteoo.ObjectTypeNode;
import org.drools.core.reteoo.RightTuple;
import org.drools.core.reteoo.RightTupleSink;
import org.drools.core.common.PropagationContext;
import org.drools.core.reteoo.TerminalNode;
import org.kie.api.definition.rule.Rule;

public class MockRightTupleSink
    implements
        RightTupleSink {
    
    private final List        retracted        = new ArrayList();

    public void retractRightTuple(RightTuple rightTuple,
                                  PropagationContext context,
                                  ReteEvaluator reteEvaluator) {
        this.retracted.add( new Object[]{rightTuple, context, reteEvaluator} );

    }

    @Override
    public int getPosInSegment() {
        return 0;
    }

    public List getRetracted() {
        return this.retracted;
    }

    public int getId() {
        return 0;
    }

    public RuleBasePartitionId getPartitionId() {
        return null;
    }

    public void writeExternal( ObjectOutput out ) throws IOException {
    }

    public void readExternal( ObjectInput in ) throws IOException, ClassNotFoundException {
    }

    public short getType() {
        return NodeTypeEnums.JoinNode;
    }

    public void modifyRightTuple(RightTuple rightTuple,
                                 PropagationContext context,
                                 ReteEvaluator reteEvaluator) {
    }

    public boolean isAssociatedWith( Rule rule ) {
        return false;
    }

    @Override public Rule[] getAssociatedRules() {
        return new Rule[0];
    }

    @Override
    public Map<Integer, TerminalNode> getAssociatedTerminals() {
        return null;
    }

    public ObjectTypeNode.Id getRightInputOtnId() {
        return null;
    }

    public boolean thisNodeEquals(final Object object) {
        return false;
    }

    public int nodeHashCode() {return this.hashCode();}

    @Override
    public NetworkNode[] getSinks() {
        return new NetworkNode[0];
    }
}
