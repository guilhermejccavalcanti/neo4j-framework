/*
 * Copyright (c) 2013 GraphAware
 *
 * This file is part of GraphAware.
 *
 * GraphAware is free software: you can redistribute it and/or modify it under the terms of
 * the GNU General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details. You should have received a copy of
 * the GNU General Public License along with this program.  If not, see
 * <http://www.gnu.org/licenses/>.
 */

package com.graphaware.server;

import com.graphaware.server.web.GraphAwareJetty9WebServer;
import org.neo4j.kernel.logging.Logging;
import org.neo4j.server.configuration.Configurator;
import org.neo4j.server.enterprise.EnterpriseNeoServer;
import org.neo4j.server.web.WebServer;

/**
 *  {@link org.neo4j.server.CommunityNeoServer} that uses {@link com.graphaware.server.web.GraphAwareJetty9WebServer}.
 */
public class GraphAwareEnterpriseNeoServer extends EnterpriseNeoServer {

    public GraphAwareEnterpriseNeoServer(Configurator configurator, Logging logging) {
        super(configurator, logging);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected WebServer createWebServer() {
        return new GraphAwareJetty9WebServer(logging);
    }
}
