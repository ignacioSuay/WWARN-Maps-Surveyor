package org.wwarn.mapcore.client.components.customwidgets;

/*
 * #%L
 * MapCore
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

import com.google.gwt.maps.client.LoadApi;
import org.wwarn.mapcore.client.components.customwidgets.map.GenericMarker;
import org.wwarn.mapcore.client.components.customwidgets.map.GoogleV3MapWidget;
import org.wwarn.mapcore.client.components.customwidgets.map.MapBuilder;
import org.wwarn.mapcore.client.components.customwidgets.map.MapMarkerBuilder;
import org.wwarn.mapcore.client.utils.AbstractMapsGWTTestHelper;

/**
 *
 */
public class GwtTestGenericMarker extends AbstractMapsGWTTestHelper{

    public void testMarkerSetup() throws Exception {
        asyncLibTest(new Runnable() {
            @Override
            public void run() {
                MapMarkerBuilder builder = new MapMarkerBuilder();
                builder.setMarkerLon(47.8);
                builder.setMarkerLat(-121.4);
                builder.setTitle("marker title");
                GenericMarker marker = builder.createMarker(new String(), getMap());
                assertNotNull(marker);
                //must call
                finishTest();
            }
        });
    }

    private GoogleV3MapWidget getMap() {
        MapBuilder builder = new MapBuilder();
        GoogleV3MapWidget mapWidget = (GoogleV3MapWidget) builder.configureMapDimension(400, 500).setCenter(1.0, 1.0).createMapWidget();
        return mapWidget;
    }

    @Override
    public LoadApi.LoadLibrary[] getLibraries() {
        return null;
    }

    @Override
    public String getModuleName() {
        return "org.wwarn.mapcore.Map";
    }
}
