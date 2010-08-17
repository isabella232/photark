/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
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

package org.apache.photark.security.authorization.services;

import org.apache.photark.security.authorization.AccessList;
import org.apache.photark.security.authorization.User;
import org.oasisopen.sca.annotation.Remotable;

/**
 * the interface for the local classes
 *
 */
@Remotable
public interface AccessManager {

    AccessList createAccessList(String userId, String email);

    AccessList updateAccessList(String userId);

    void addUserToList(User user, String listName);

    void removeUserFromList(String userId, String listName);

    boolean isUserStoredInList(String userId, String listName);

    User getUser(String userId);

    boolean isPermitted(String userId, String albumName, String[] permissionNames);

    AccessList getAccessListFromUserId(String userId);

    boolean isUserActive(String userId);

    String getSecurityTokenFromUserId(String userId);

    void putAccessListAndToken(AccessList accessList, String token);

    void removeAccessListAndToken(String userId);

    AccessList getAccessListFromSecurityToken(String token);

    String getUserIdFromSecurityToken(String token);
}
