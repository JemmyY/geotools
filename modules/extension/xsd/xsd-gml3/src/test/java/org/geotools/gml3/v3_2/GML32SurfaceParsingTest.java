package org.geotools.gml3.v3_2;

import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;
import org.geotools.geometry.jts.CompoundRing;
import org.geotools.xml.Parser;

public class GML32SurfaceParsingTest extends GML32TestSupport {

    public void testMultiSurface() throws Exception {
        GMLConfiguration gml = new GMLConfiguration(true);
        Parser p = new Parser(gml);
        Object multiSurface = p.parse(getClass().getResourceAsStream("multisurface.xml"));
        assertTrue(multiSurface instanceof MultiPolygon);
        MultiPolygon mp = (MultiPolygon) multiSurface;
        assertEquals(1, mp.getNumGeometries());
        Polygon poly = (Polygon) mp.getGeometryN(0);
        assertTrue(poly.getExteriorRing() instanceof CompoundRing);
    }
}
