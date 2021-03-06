/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ewerk.prototype.persistence.repositories;

import com.ewerk.prototype.model.Person;

/**
 * Spring-data custom repository declaration for the {@link Person} entity.
 *
 * @author holgerstolzenberg
 * @since 0.0.3
 */
public interface PersonRepositoryCustom {
  Person create(Person person);

  Iterable<Person> locate(String lastName, String firstName);
}
