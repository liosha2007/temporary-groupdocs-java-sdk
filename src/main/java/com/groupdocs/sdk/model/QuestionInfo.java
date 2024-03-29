/**
 *  Copyright 2012 GroupDocs.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.groupdocs.sdk.model;

import java.util.*;
import com.groupdocs.sdk.model.AnswerInfo;
/**
 * 
 * <p>
 * NOTE: This class is auto generated by the swagger code generator program. Do not edit the class manually.
 *
 */
public class QuestionInfo {
  private String field = null;
  private String text = null;
  private String def_answer = null;
  private Boolean required = null;
  private Boolean disabled = null;
  private String type = null;
  private List<AnswerInfo> answers = new ArrayList<AnswerInfo>();
  public String getField() {
    return field;
  }
  public void setField(String field) {
    this.field = field;
  }

  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }

  public String getDef_answer() {
    return def_answer;
  }
  public void setDef_answer(String def_answer) {
    this.def_answer = def_answer;
  }

  public Boolean getRequired() {
    return required;
  }
  public void setRequired(Boolean required) {
    this.required = required;
  }

  public Boolean getDisabled() {
    return disabled;
  }
  public void setDisabled(Boolean disabled) {
    this.disabled = disabled;
  }

  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  public List<AnswerInfo> getAnswers() {
    return answers;
  }
  public void setAnswers(List<AnswerInfo> answers) {
    this.answers = answers;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuestionInfo {\n");
    sb.append("  field: ").append(field).append("\n");
    sb.append("  text: ").append(text).append("\n");
    sb.append("  def_answer: ").append(def_answer).append("\n");
    sb.append("  required: ").append(required).append("\n");
    sb.append("  disabled: ").append(disabled).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  answers: ").append(answers).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

