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

package org.jclouds.openstack.neutron.v2.extensions;

import com.google.common.annotations.Beta;
import org.jclouds.Fallbacks;
import org.jclouds.collect.PagedIterable;
import org.jclouds.javax.annotation.Nullable;
import org.jclouds.openstack.keystone.v2_0.filters.AuthenticateRequest;
import org.jclouds.openstack.neutron.v2.domain.FloatingIP;
import org.jclouds.openstack.neutron.v2.domain.FloatingIPs;
import org.jclouds.openstack.neutron.v2.fallbacks.EmptyFloatingIPsFallback;
import org.jclouds.openstack.neutron.v2.functions.FloatingIPToPagedIterable;
import org.jclouds.openstack.neutron.v2.functions.ParseFloatingIPs;
import org.jclouds.openstack.v2_0.options.PaginationOptions;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.ResponseParser;
import org.jclouds.rest.annotations.SelectJson;
import org.jclouds.rest.annotations.Transform;
import org.jclouds.rest.annotations.WrapWith;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * Provides synchronous access to Floating IP operations on the OpenStack Neutron API.
 *
 * An external IP address that is mapped to a port that is attached to an internal network.
 * It is a part of Layer-3 networking extension.
 * 
 * @see <a href= "http://docs.openstack.org/api/openstack-network/2.0/content/router_ext.html">api doc</a>
 */
@Beta
@Path("/floatingips")
@RequestFilters(AuthenticateRequest.class)
@Consumes(MediaType.APPLICATION_JSON)
public interface FloatingIPApi {

	/**
	 * Returns the list of all currently allocated floating IP in Neutron for the current tenant.
	 *
	 * @return the list of all floating IP allocated for the tenant.
	 */
	@Named("floatingIp:list")
	@GET
	@Transform(FloatingIPToPagedIterable.class)
	@ResponseParser(ParseFloatingIPs.class)
	@Fallback(Fallbacks.EmptyPagedIterableOnNotFoundOr404.class)
	PagedIterable<FloatingIP> list();

	/**
	 * @see <a href="http://docs.openstack.org/api/openstack-network/2.0/content/pagination.html">api doc</a>
	 */
	@Named("floatingIp:list")
	@GET
	@ResponseParser(ParseFloatingIPs.class)
	@Fallback(EmptyFloatingIPsFallback.class)
	FloatingIPs list(PaginationOptions options);

	/**
	 * Returns a floating IP information or null if not found
	 *
	 * @param id
	 *            the id of the floating IP to return
	 * @return Floating IP information or null if not found
	 */
	@Named("floatingIp:get")
	@GET
	@Path("/{id}")
	@SelectJson("floatingip")
	@Fallback(Fallbacks.NullOnNotFoundOr404.class)
	@Nullable
	FloatingIP get(@PathParam("id") String id);

	/**
	 * Creates a floating IP, and, if you specify port information, associates the floating IP with an internal port.
	 *
	 * @param floatingIP
	 *            Options for creating a floating IP
	 * @return the newly created floating IP
	 */
	@Named("floatingIp:create")
	@POST
	@SelectJson("floatingip")
	FloatingIP create(@WrapWith("floatingip") FloatingIP.CreateOptions floatingIP);

	/**
	 * Updates a floating IP and its association with an internal port.
	 *
	 * @param id
	 *            the id of the floating IP to update
	 * @param floatingIP
	 *            Contains only the attributes to update
	 * @return The modified floating IP
	 */
	@Named("floatingIp:update")
	@PUT
	@Path("/{id}")
	@SelectJson("floatingip")
	@Fallback(Fallbacks.NullOnNotFoundOr404.class)
	@Nullable
	FloatingIP update(@PathParam("id") String id, @WrapWith("floatingip") FloatingIP.UpdateOptions floatingIP);

	/**
	 * Release a floating IP and return it to pool.
	 *
	 * @param id
	 *            the id of the floating IP to release
	 * @return true if release successful, false if floating IP not
	 */
	@Named("floatingIp:delete")
	@DELETE
	@Path("/{id}")
	@Fallback(Fallbacks.FalseOnNotFoundOr404.class)
	boolean delete(@PathParam("id") String id);
}
