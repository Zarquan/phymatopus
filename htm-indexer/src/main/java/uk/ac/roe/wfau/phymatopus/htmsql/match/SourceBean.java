/*
 *  Copyright (C) 2018 Royal Observatory, University of Edinburgh, UK
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package uk.ac.roe.wfau.phymatopus.htmsql.match;

/**
 * Bean class to represent a source.
 * 
 *
 */
public interface SourceBean
    {
    /**
     * The name of the catalog containing the source.
     * 
     */
    public String getCatalog();
    /**
     * The source ID within the catalog.
     * 
     */
    public String getSource();
    /**
     * The HTM triangle that contains the source.
     * 
     */
    public long getHtmid();
    
    /**
     * The source position ra.
     * 
     */
    public double getRa();
    
    /**
     * The source position dec.
     * 
     */
    public double getDec();
    
    /**
     * The source position.
     * 
     */
    public double[] getPosition();
    
    }