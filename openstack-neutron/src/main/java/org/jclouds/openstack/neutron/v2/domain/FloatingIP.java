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

package org.jclouds.openstack.neutron.v2.domain;

import com.google.common.base.Objects;
import org.jclouds.javax.annotation.Nullable;

import javax.inject.Named;
import java.beans.ConstructorProperties;

/**
 * A Neutron Floating IP
 *
 * @see <a href="http://docs.openstack.org/api/openstack-network/2.0/content/router_ext_concepts.html">api doc</a>
 */
public class FloatingIP {

	private String id;
	private NetworkStatus status;

	@Named("tenant_id")
	private String tenantId;
	@Named("router_id")
	private String routerId;
	@Named("floating_network_id")
	private String floatingNetworkId;
	@Named("fixed_ip_address")
	private String fixedIpAddress;
	@Named("floating_ip_address")
	private String floatingIpAddress;
	@Named("port_id")
	private String portId;


	/**
	 * @param id
	 * @param status
	 * @param tenantId
	 * @param routerId
	 * @param floatingNetworkId
	 * @param fixedIpAddress
	 * @param floatingIpAddress
	 * @param portId
	 */
	@ConstructorProperties({ "id", "status", "tenant_id", "router_id", "floating_network_id", "fixed_ip_address",
			"floating_ip_address", "port_id" })
	private FloatingIP(String id, NetworkStatus status, String tenantId, String routerId, String floatingNetworkId,
			String fixedIpAddress, String floatingIpAddress, String portId) {
		this.id = id;
		this.status = status;
		this.tenantId = tenantId;
		this.routerId = routerId;
		this.floatingNetworkId = floatingNetworkId;
		this.fixedIpAddress = fixedIpAddress;
		this.floatingIpAddress = floatingIpAddress;
		this.portId = portId;
	}

	/**
	 * Default constructor.
	 */
	private FloatingIP() {
	}

	/**
	 * Copy constructor
	 * 
	 * @param floatingIP
	 */
	private FloatingIP(FloatingIP floatingIP) {
		this(floatingIP.id, floatingIP.status, floatingIP.tenantId, floatingIP.routerId, floatingIP.floatingNetworkId,
				floatingIP.fixedIpAddress, floatingIP.floatingIpAddress, floatingIP.portId);
	}

	/**
	 * @return the id of the Floating IP
	 */
	@Nullable
	public String getId() {
		return id;
	}

	/**
	 * @return the status of the Floating IP
	 */
	@Nullable
	public NetworkStatus getStatus() {
		return status;
	}

	/**
	 * @return the tenantId of the Router
	 */
	@Nullable
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * @return The router ID
	 */
	@Nullable
	public String getRouterId() {
		return routerId;
	}

	/**
	 * @return he ID of the network associated with the floating IP
	 */
	@Nullable
	public String getFloatingNetworkId() {
		return floatingNetworkId;
	}

	/**
	 * @return The fixed IP address associated with the floating IP
	 */
	@Nullable
	public String getFixedIpAddress() {
		return fixedIpAddress;
	}

	/**
	 * @return The floating IP address
	 */
	@Nullable
	public String getFloatingIpAddress() {
		return floatingIpAddress;
	}

	/**
	 * @return The port ID associated with the floating IP
	 */
	@Nullable
	public String getPortId() {
		return portId;
	}

	/**
	 * @return the Builder for creating a new Router
	 */
	public static CreateBuilder createOptions() {
		return new CreateBuilder();
	}

	/**
	 * @return the Builder for updating a Router
	 */
	public static UpdateBuilder updateOptions() {
		return new UpdateBuilder();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		FloatingIP that = (FloatingIP) o;

		return Objects.equal(this.id, that.id) &&
				Objects.equal(this.status, that.status) &&
				Objects.equal(this.tenantId, that.tenantId) &&
				Objects.equal(this.routerId, that.routerId) &&
				Objects.equal(this.floatingNetworkId, that.floatingNetworkId) &&
				Objects.equal(this.fixedIpAddress, that.fixedIpAddress) &&
				Objects.equal(this.floatingIpAddress, that.floatingIpAddress) &&
				Objects.equal(this.portId, that.portId);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id, status, tenantId, routerId, floatingNetworkId, fixedIpAddress, floatingIpAddress,
				portId);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("id", id)
				.add("status", status)
				.add("tenantId", tenantId)
				.add("routerId", routerId)
				.add("floatingNetworkId", floatingNetworkId)
				.add("fixedIpAddress", fixedIpAddress)
				.add("floatingIpAddress", floatingIpAddress)
				.add("portId", portId)
				.toString();
	}

	private static abstract class Builder<ParameterizedBuilderType> {
		protected FloatingIP floatingIP;

		/**
		 * No-parameters constructor used when updating.
		 * */
		private Builder() {
			floatingIP = new FloatingIP();
		}

		protected abstract ParameterizedBuilderType self();

		/**
		 * @return the Builder.
		 * @see FloatingIP#getTenantId()
		 */
		public ParameterizedBuilderType tenantId(String tenantId) {
			floatingIP.tenantId = tenantId;
			return self();
		}

		/**
		 * @return the Builder.
		 * @see FloatingIP#getRouterId()
		 */
		public ParameterizedBuilderType routerId(String routerId) {
			floatingIP.routerId = routerId;
			return self();
		}

		/**
		 * @return the Builder.
		 * @see FloatingIP#getFloatingNetworkId()
		 */
		public ParameterizedBuilderType floatingNetworkId(String floatingNetworkId) {
			floatingIP.floatingNetworkId = floatingNetworkId;
			return self();
		}

		/**
		 * @return the Builder.
		 * @see FloatingIP#getFixedIpAddress()
		 */
		public ParameterizedBuilderType fixedIpAddress(String fixedIpAddress) {
			floatingIP.fixedIpAddress = fixedIpAddress;
			return self();
		}

		/**
		 * @return the Builder.
		 * @see FloatingIP#getFloatingIpAddress()
		 */
		public ParameterizedBuilderType floatingIpAddress(String floatingIpAddress) {
			floatingIP.floatingIpAddress = floatingIpAddress;
			return self();
		}

		/**
		 * @return the Builder.
		 * @see FloatingIP#getPortId()
		 */
		public ParameterizedBuilderType portId(String portId) {
			floatingIP.portId = portId;
			return self();
		}
	}

	public static class CreateBuilder extends Builder<CreateBuilder> {
		/**
		 * Supply required properties for creating a Builder
		 */
		private CreateBuilder() {
		}

		/**
		 * @return a CreateOptions constructed with this Builder.
		 */
		public CreateOptions build() {
			return new CreateOptions(floatingIP);
		}

		protected CreateBuilder self() {
			return this;
		}
	}

	public static class UpdateBuilder extends Builder<UpdateBuilder> {
		/**
		 * Supply required properties for updating a Builder
		 */
		private UpdateBuilder() {
		}

		/**
		 * @return a UpdateOptions constructed with this Builder.
		 */
		public UpdateOptions build() {
			return new UpdateOptions(floatingIP);
		}

		protected UpdateBuilder self() {
			return this;
		}
	}

	public static class CreateOptions extends FloatingIP {
		/**
		 * Copy constructor
		 */
		private CreateOptions(FloatingIP floatingIP) {
			super(floatingIP);
		}
	}

	public static class UpdateOptions extends FloatingIP {
		/**
		 * Copy constructor
		 */
		private UpdateOptions(FloatingIP floatingIP) {
			super(floatingIP);
		}
	}
}
