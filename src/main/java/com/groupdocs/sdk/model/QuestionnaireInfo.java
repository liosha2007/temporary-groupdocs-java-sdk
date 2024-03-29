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
import com.groupdocs.sdk.model.QuestionnairePageInfo;
/**
 * 
 * <p>
 * NOTE: This class is auto generated by the swagger code generator program. Do not edit the class manually.
 *
 */
public class QuestionnaireInfo {
  private Integer resolved_executions = null;
  private List<QuestionnairePageInfo> pages = new ArrayList<QuestionnairePageInfo>();
  private List<String> document_ids = new ArrayList<String>();
  private Double id = null;
  private String guid = null;
  private String name = null;
  private String descr = null;
  private String status = null;
  private Integer assigned_questions = null;
  private Integer total_questions = null;
  private Long modified = null;
  private Long expires = null;
  private String folder = null;
  private String emails = null;
  public Integer getResolved_executions() {
    return resolved_executions;
  }
  public void setResolved_executions(Integer resolved_executions) {
    this.resolved_executions = resolved_executions;
  }

  public List<QuestionnairePageInfo> getPages() {
    return pages;
  }
  public void setPages(List<QuestionnairePageInfo> pages) {
    this.pages = pages;
  }

  public List<String> getDocument_ids() {
    return document_ids;
  }
  public void setDocument_ids(List<String> document_ids) {
    this.document_ids = document_ids;
  }

  public Double getId() {
    return id;
  }
  public void setId(Double id) {
    this.id = id;
  }

  public String getGuid() {
    return guid;
  }
  public void setGuid(String guid) {
    this.guid = guid;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getDescr() {
    return descr;
  }
  public void setDescr(String descr) {
    this.descr = descr;
  }

  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  public Integer getAssigned_questions() {
    return assigned_questions;
  }
  public void setAssigned_questions(Integer assigned_questions) {
    this.assigned_questions = assigned_questions;
  }

  public Integer getTotal_questions() {
    return total_questions;
  }
  public void setTotal_questions(Integer total_questions) {
    this.total_questions = total_questions;
  }

  public Long getModified() {
    return modified;
  }
  public void setModified(Long modified) {
    this.modified = modified;
  }

  public Long getExpires() {
    return expires;
  }
  public void setExpires(Long expires) {
    this.expires = expires;
  }

  public String getFolder() {
    return folder;
  }
  public void setFolder(String folder) {
    this.folder = folder;
  }

  public String getEmails() {
    return emails;
  }
  public void setEmails(String emails) {
    this.emails = emails;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuestionnaireInfo {\n");
    sb.append("  resolved_executions: ").append(resolved_executions).append("\n");
    sb.append("  pages: ").append(pages).append("\n");
    sb.append("  document_ids: ").append(document_ids).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  guid: ").append(guid).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  descr: ").append(descr).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  assigned_questions: ").append(assigned_questions).append("\n");
    sb.append("  total_questions: ").append(total_questions).append("\n");
    sb.append("  modified: ").append(modified).append("\n");
    sb.append("  expires: ").append(expires).append("\n");
    sb.append("  folder: ").append(folder).append("\n");
    sb.append("  emails: ").append(emails).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

