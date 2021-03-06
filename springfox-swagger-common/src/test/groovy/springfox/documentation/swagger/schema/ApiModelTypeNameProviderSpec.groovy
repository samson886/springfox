/*
 *
 *  Copyright 2015 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */

package springfox.documentation.swagger.schema
import spock.lang.Specification
import springfox.documentation.schema.ExampleWithEnums
import springfox.documentation.schema.TypeWithApiModelAnnotation
import springfox.documentation.schema.TypeWithEmptyApiModelAnnotation
import springfox.documentation.spi.DocumentationType

class ApiModelTypeNameProviderSpec extends Specification {
  def "renders the type names correctly" () {
    given:
      def sut = new ApiModelTypeNameProvider()
    when:
      def name = sut.nameFor(clazz)
    then:
      name == expectedName
    and:
      !sut.supports(DocumentationType.SPRING_WEB)
      sut.supports(DocumentationType.SWAGGER_12)
      sut.supports(DocumentationType.SWAGGER_2)

    where:
      clazz                           | expectedName
      ExampleWithEnums                | "ExampleWithEnums"
      TypeWithApiModelAnnotation      | "ApiModelTest"
      TypeWithEmptyApiModelAnnotation | "TypeWithEmptyApiModelAnnotation"
  }
}
