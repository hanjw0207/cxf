/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.cxf.sts.event;

import org.apache.log4j.PatternLayout;

public class LoggerPatternLayoutLog4J extends PatternLayout {

    private String header;  
    
    public void setHeader(String header) {  
        this.header = header;  
    }  
  
    @Override
    public String getHeader() {
        if (this.header != null) {
            return this.header + System.getProperty("line.separator");
        }
        LoggerListener ll = new LoggerListener();
        StringBuffer line = new StringBuffer();
        for (String item : ll.getFieldOrder()) {
            line.append(item).append(";");
        }
        return line.toString() + System.getProperty("line.separator");
    }  
    
}
