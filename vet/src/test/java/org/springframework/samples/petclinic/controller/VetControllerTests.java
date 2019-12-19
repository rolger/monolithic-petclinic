/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.samples.petclinic.vets.VetRepository;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Test class for the {@link VetController}
 */
@WebMvcTest(VetController.class)
class VetControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VetRepository service;

//    @BeforeEach
//    void setup() {
//        VetDto james = createVet("James", "Carter", 1, Collections.emptyList());
//        VetDto helen = createVet("Helen", "Leary", 2, Collections.singletonList("radiology"));
//        given(this.service.allVets()).willReturn(Lists.newArrayList(james, helen));
//    }
//
//    private VetDto createVet(String james2, String carter, int i, List<String> specialties) {
//        return new VetDto(james2, carter, specialties);
//    }
//
//    @Test
//    void testShowVetListHtml() throws Exception {
//        mockMvc.perform(get("/vets.html"))
//            .andExpect(status().isOk())
//            .andExpect(model().attributeExists("vetList"))
//            .andExpect(view().name("vets/vetList"));
//    }

}