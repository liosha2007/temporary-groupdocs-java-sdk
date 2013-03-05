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

/**
 * 
 * <p>
 * NOTE: This class is auto generated by the swagger code generator program. Do not edit the class manually.
 *
 */
public class CreateJobResult {
  private Double job_id = null;
  private String job_guid = null;
  public Double getJob_id() {
    return job_id;
  }
  public void setJob_id(Double job_id) {
    this.job_id = job_id;
  }

  public String getJob_guid() {
    return job_guid;
  }
  public void setJob_guid(String job_guid) {
    this.job_guid = job_guid;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateJobResult {\n");
    sb.append("  job_id: ").append(job_id).append("\n");
    sb.append("  job_guid: ").append(job_guid).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
