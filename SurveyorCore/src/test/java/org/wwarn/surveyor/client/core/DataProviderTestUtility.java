package org.wwarn.surveyor.client.core;

/*
 * #%L
 * SurveyorCore
 * %%
 * Copyright (C) 2013 - 2014 University of Oxford
 * %%
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * 3. Neither the name of the University of Oxford nor the names of its contributors
 *    may be used to endorse or promote products derived from this software without
 *    specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import org.wwarn.surveyor.client.model.DataSourceProvider;
import org.wwarn.surveyor.client.model.DatasourceConfig;

import java.util.Date;

public class DataProviderTestUtility {

    public static final String FIELD_PUBLICATION_YEAR = "PY";

    public DataProviderTestUtility() {
    }

    public static final Date DATE_START_2001 = DataType.ParseUtil.parseDateInEnglishDayMonthYearFormat("01/01/2001");
    public static final Date DATE_END_2003 = DataType.ParseUtil.parseDateInEnglishDayMonthYearFormat("31/12/2003");

    public String[] getSelectorList() {
        return new String[]{"PUB", "PTN", "QI", "TTL"};
    }

    public DataSchema fetchSampleDataSchema() {
        String dataSourceType = DataSourceProvider.LocalClientSideDataProvider.name();
        DatasourceConfig dataSourceConfig = new DatasourceConfig("uniqueID","f", dataSourceType);
        DataSchema schema = new DataSchema(dataSourceConfig);
        schema.addField(FIELD_PUBLICATION_YEAR, DataType.DateYear);
        schema.addField("PUB", DataType.String);
        schema.addField("PTN", DataType.String);
        schema.addField("CLAT", DataType.CoordinateLat);
        schema.addField("CLON", DataType.CoordinateLon);
        schema.addField("PID", DataType.Integer);
        schema.addField("QI", DataType.String);
        schema.addField("SD", DataType.Date);
        schema.addField("TTL", DataType.String);
        return schema;
    }

    private static String getJSON(){
        return Constants.JSON_DATA_SOURCE;
    }

    public JSONArray getJSONArray() {
        return JSONParser.parseStrict(getJSON()).isArray();
    }

    public interface DataProviderSource{
        final public DataProviderTestUtility testUtility = new DataProviderTestUtility();
        public JSONArray jsonArray = testUtility.getJSONArray();
        public DataSchema schema = testUtility.fetchSampleDataSchema();
        DataProvider getDataProvider();
    }
}
