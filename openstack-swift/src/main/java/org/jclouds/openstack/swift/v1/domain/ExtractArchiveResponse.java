/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.openstack.swift.v1.domain;

import static com.google.common.base.Objects.equal;
import static com.google.common.base.Objects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import com.google.common.base.Objects;

/**
 * @see <a
 *      href="http://docs.openstack.org/developer/swift/misc.html#module-swift.common.middleware.bulk">
 *      Swift Bulk Middleware</a>
 */
public class ExtractArchiveResponse {
   public static ExtractArchiveResponse create(int created, Map<String, String> errors) {
      return new ExtractArchiveResponse(created, errors);
   }

   private final int created;
   private final Map<String, String> errors;

   private ExtractArchiveResponse(int created, Map<String, String> errors) {
      this.created = created;
      this.errors = checkNotNull(errors, "errors");
   }

   /** number of files created. */
   public int created() {
      return created;
   }

   /** For each path that failed to create, a corresponding error response. */
   public Map<String, String> errors() {
      return errors;
   }

   @Override
   public boolean equals(Object object) {
      if (this == object) {
         return true;
      }
      if (object instanceof ExtractArchiveResponse) {
         ExtractArchiveResponse that = ExtractArchiveResponse.class.cast(object);
         return equal(created(), that.created()) //
               && equal(errors(), that.errors());
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return Objects.hashCode(created(), errors());
   }

   @Override
   public String toString() {
      return toStringHelper("") //
            .add("created", created()) //
            .add("errors", errors()).toString();
   }
}
