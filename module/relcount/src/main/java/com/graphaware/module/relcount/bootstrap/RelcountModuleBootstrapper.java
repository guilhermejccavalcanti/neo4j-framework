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

package com.graphaware.module.relcount.bootstrap;

import com.graphaware.runtime.GraphAwareRuntime;
import com.graphaware.runtime.GraphAwareRuntimeModuleBootstrapper;
import com.graphaware.module.relcount.RelationshipCountRuntimeModule;
import org.neo4j.graphdb.config.Setting;
import org.neo4j.kernel.configuration.Config;

import static org.neo4j.helpers.Settings.STRING;
import static org.neo4j.helpers.Settings.setting;

/**
 * {@link com.graphaware.runtime.GraphAwareRuntimeModuleBootstrapper} for {@link com.graphaware.module.relcount.RelationshipCountRuntimeModule}.
 */
public class RelcountModuleBootstrapper implements GraphAwareRuntimeModuleBootstrapper {

    public static final Setting<String> MODULE_ENABLED = setting("com.graphaware.module.relcount.enabled", STRING, RelcountModuleBootstrapper.class.getCanonicalName());

    /**
     * {@inheritDoc}
     */
    @Override
    public void bootstrap(GraphAwareRuntime runtime, Config config) {
        runtime.registerModule(new RelationshipCountRuntimeModule());
    }
}