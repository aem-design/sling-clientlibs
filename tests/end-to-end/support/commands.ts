/*
 * Copyright (C) 2022 AEM.Design
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

Cypress.Commands.add('login', () => {
  const authUrl = `${
    Cypress.env('baseUrl') || ''
  }/apps/websight-authentication/j_security_check`;

  cy.session('admin', () => {
    cy.request({
      method: 'POST',
      url: authUrl,
      form: true,
      body: {
        j_username: Cypress.env('loginUsername'),
        j_password: Cypress.env('loginPassword'),
        resource: '/apps/websight/index.html/content::spaces',
        _charset_: 'UTF-8'
      }
    });
  });
});
