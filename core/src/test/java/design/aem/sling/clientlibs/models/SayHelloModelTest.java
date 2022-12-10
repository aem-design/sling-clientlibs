/*
 * Copyright (C) 2022 Dynamic Solutions
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package design.aem.sling.clientlibs.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.apache.sling.testing.mock.sling.junit5.SlingContext;
import org.apache.sling.testing.mock.sling.junit5.SlingContextExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SlingContextExtension.class)
class SayHelloModelTest {

    private final SlingContext context = new SlingContext(ResourceResolverType.JCR_MOCK);

    @Test
    void shouldReturnDefaultHelloText() {
        Resource resource = context.create().resource("/content/test");

        SayHelloModel model = resource.adaptTo(SayHelloModel.class);

        assertNotNull(model);
        assertEquals("Hello World!", model.getHelloText());
    }

    @Test
    void shouldReturnHelloTextWithInjectedValue() {
        Resource resource = context.create().resource("/content/test", Map.of("helloName", "Devs"));

        SayHelloModel model = resource.adaptTo(SayHelloModel.class);

        assertNotNull(model);
        assertEquals("Hello Devs!", model.getHelloText());
    }
}
