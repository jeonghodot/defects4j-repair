/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.lang.text;

import java.text.DateFormat;
import java.util.Locale;
import java.util.Map;

/**
 * Stock "time" MetaFormat.
 * 
 * @see ExtendedMessageFormat
 * @author Matt Benson
 * @since 2.4
 * @version $Id$
 */
public class TimeMetaFormat extends DateMetaFormatSupport {
    private static final long serialVersionUID = -4959095416302142342L;

    /**
     * Create a new TimeMetaFormat.
     */
    public TimeMetaFormat() {
        super();
    }

    /**
     * Create a new NumberMetaFormat.
     * 
     * @param locale Locale
     */
    public TimeMetaFormat(Locale locale) {
        super(locale);
    }

    /** {@inheritDoc} */
    protected DateFormat createSubformatInstance(int style) {
        return DateFormat.getTimeInstance(style, getLocale());
    }

    /** {@inheritDoc} */
    protected Map createInverseStyleMap() {
        Map invertMe = createStyleMap();
        invertMe.remove(DEFAULT);
        DateFormat longDf = DateFormat.getTimeInstance(DateFormat.LONG,
                getLocale());
        DateFormat fullDf = DateFormat.getTimeInstance(DateFormat.FULL,
                getLocale());
        if (fullDf.equals(longDf)) {
            invertMe.remove(FULL);
        }
        return invert(invertMe);
    }
}
