/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.jclouds.openstack.neutron.v2.functions;

import com.google.inject.TypeLiteral;
import org.jclouds.http.functions.ParseJson;
import org.jclouds.json.Json;
import org.jclouds.openstack.neutron.v2.domain.FloatingIPs;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Used by jclouds to provide more specific collections and fallbacks.
 */
@Singleton
public class ParseFloatingIPs  extends ParseJson<FloatingIPs> {

	@Inject
	public ParseFloatingIPs(Json json) {
		super(json, TypeLiteral.get(FloatingIPs.class));
	}

}
