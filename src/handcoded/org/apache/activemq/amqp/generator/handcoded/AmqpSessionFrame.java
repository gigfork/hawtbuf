/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with his work
 * for additional information regarding copyright ownership. The ASF licenses
 * this file to You under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.apache.activemq.amqp.generator.handcoded;

public class AmqpSessionFrame extends AmqpFrame {

    private static final byte COMMAND_MASK = 0x01;
    private static final byte NO_EXECUTED_MASK = 0x02;
    private static final byte SYNC_MASK = 0x04;

    private static final int ACKNOWLEDGED_OFFSET = 8;
    private static final int NO_EXECUTED_OFFSET = 12;
    private static final int CAPACITY_OFFSET = 16;
    private static final int COMMAND_ID_OFFSET = 20;

    public void setCommand(boolean isCommand) {
        if (isCommand) {
            frameHeader[FLAGS_OFFSET] |= COMMAND_MASK;
        } else {
            frameHeader[FLAGS_OFFSET] &= ~COMMAND_MASK;
        }
    }

    public boolean isCommand() {
        return (frameHeader[FLAGS_OFFSET] & COMMAND_MASK) != 0;
    }

    public void setNoExecuted(boolean isNoExecuted) {
        if (isNoExecuted) {
            frameHeader[FLAGS_OFFSET] |= NO_EXECUTED_MASK;
        } else {
            frameHeader[FLAGS_OFFSET] &= ~NO_EXECUTED_MASK;
        }
    }

    public boolean isNoExecuted() {
        return (frameHeader[FLAGS_OFFSET] & NO_EXECUTED_MASK) != 0;
    }

    public void setSync(boolean isSync) {
        if (isSync) {
            frameHeader[FLAGS_OFFSET] |= SYNC_MASK;
        } else {
            frameHeader[FLAGS_OFFSET] &= ~SYNC_MASK;
        }
    }

    public boolean isSync() {
        return (frameHeader[FLAGS_OFFSET] & SYNC_MASK) != 0;
    }

    public void setAcknowledged(long acknowledged) {
        BitUtils.setUInt(frameHeader, ACKNOWLEDGED_OFFSET, acknowledged);
    }

    public long getAcknowledged() {
        return BitUtils.getUInt(frameHeader, ACKNOWLEDGED_OFFSET);
    }

    public void setNoExecuted(long noExecuted) {
        BitUtils.setUInt(frameHeader, NO_EXECUTED_OFFSET, noExecuted);
    }

    public long getNoExecuted() {
        return BitUtils.getUInt(frameHeader, NO_EXECUTED_OFFSET);
    }

    public void setCapacity(long capacity) {
        BitUtils.setUInt(frameHeader, CAPACITY_OFFSET, capacity);
    }

    public long getCapacity() {
        return BitUtils.getUInt(frameHeader, CAPACITY_OFFSET);
    }
    
    public void setCommandId(long commandId) {
        BitUtils.setUInt(frameHeader, COMMAND_ID_OFFSET, commandId);
    }

    public long getCommandId() {
        return BitUtils.getUInt(frameHeader, COMMAND_ID_OFFSET);
    }
}
