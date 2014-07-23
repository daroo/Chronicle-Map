/*
 * Copyright 2014 Higher Frequency Trading
 * <p/>
 * http://www.higherfrequencytrading.com
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.openhft.chronicle.map.others;/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * @test
 * @bug 6312706
 * @summary Sets from Map.entrySet() return distinct objects for each Entry
 * @author Neil Richards <neil.richards@ngmr.net>, <neil_richards@uk.ibm.com>
 */

import java.util.concurrent.ConcurrentHashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DistinctEntrySetElements {
    public static void main(String[] args) throws Exception {
        final ConcurrentHashMap<String, String> concurrentHashMap =
            new ConcurrentHashMap<>();

        concurrentHashMap.put("One", "Un");
        concurrentHashMap.put("Two", "Deux");
        concurrentHashMap.put("Three", "Trois");

        Set<Map.Entry<String, String>> entrySet = concurrentHashMap.entrySet();
        HashSet<Map.Entry<String, String>> hashSet = new HashSet<>(entrySet);

        if (false == hashSet.equals(entrySet)) {
            throw new RuntimeException("Test FAILED: Sets are not equal.");
        }
        if (hashSet.hashCode() != entrySet.hashCode()) {
            throw new RuntimeException("Test FAILED: Set's hashcodes are not equal.");
        }
    }
}