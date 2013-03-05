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

import com.groupdocs.sdk.model.UserIdentity;
import com.groupdocs.sdk.model.DocumentDownloadInfo;
/**
 * 
 * <p>
 * NOTE: This class is auto generated by the swagger code generator program. Do not edit the class manually.
 *
 */
public class QuestionnaireExecutionInfo {
  private String status = null;
  private String guid = null;
  private Double collector_id = null;
  private String collector_guid = null;
  private String questionnaire_name = null;
  private UserIdentity owner = null;
  private UserIdentity executive = null;
  private UserIdentity approver = null;
  private Double datasource_id = null;
  private Double id = null;
  private Long modified = null;
  private DocumentDownloadInfo document = null;
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  public String getGuid() {
    return guid;
  }
  public void setGuid(String guid) {
    this.guid = guid;
  }

  public Double getCollector_id() {
    return collector_id;
  }
  public void setCollector_id(Double collector_id) {
    this.collector_id = collector_id;
  }

  public String getCollector_guid() {
    return collector_guid;
  }
  public void setCollector_guid(String collector_guid) {
    this.collector_guid = collector_guid;
  }

  public String getQuestionnaire_name() {
    return questionnaire_name;
  }
  public void setQuestionnaire_name(String questionnaire_name) {
    this.questionnaire_name = questionnaire_name;
  }

  public UserIdentity getOwner() {
    return owner;
  }
  public void setOwner(UserIdentity owner) {
    this.owner = owner;
  }

  public UserIdentity getExecutive() {
    return executive;
  }
  public void setExecutive(UserIdentity executive) {
    this.executive = executive;
  }

  public UserIdentity getApprover() {
    return approver;
  }
  public void setApprover(UserIdentity approver) {
    this.approver = approver;
  }

  public Double getDatasource_id() {
    return datasource_id;
  }
  public void setDatasource_id(Double datasource_id) {
    this.datasource_id = datasource_id;
  }

  public Double getId() {
    return id;
  }
  public void setId(Double id) {
    this.id = id;
  }

  public Long getModified() {
    return modified;
  }
  public void setModified(Long modified) {
    this.modified = modified;
  }

  public DocumentDownloadInfo getDocument() {
    return document;
  }
  public void setDocument(DocumentDownloadInfo document) {
    this.document = document;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuestionnaireExecutionInfo {\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  guid: ").append(guid).append("\n");
    sb.append("  collector_id: ").append(collector_id).append("\n");
    sb.append("  collector_guid: ").append(collector_guid).append("\n");
    sb.append("  questionnaire_name: ").append(questionnaire_name).append("\n");
    sb.append("  owner: ").append(owner).append("\n");
    sb.append("  executive: ").append(executive).append("\n");
    sb.append("  approver: ").append(approver).append("\n");
    sb.append("  datasource_id: ").append(datasource_id).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  modified: ").append(modified).append("\n");
    sb.append("  document: ").append(document).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

