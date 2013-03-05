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
public class SignatureSignatureSettings {
  private String name = null;
  private String companyName = null;
  private String position = null;
  private String firstName = null;
  private String lastName = null;
  private String textInitials = null;
  private String signatureData = null;
  private String initialsData = null;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getCompanyName() {
    return companyName;
  }
  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getPosition() {
    return position;
  }
  public void setPosition(String position) {
    this.position = position;
  }

  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getTextInitials() {
    return textInitials;
  }
  public void setTextInitials(String textInitials) {
    this.textInitials = textInitials;
  }

  public String getSignatureData() {
    return signatureData;
  }
  public void setSignatureData(String signatureData) {
    this.signatureData = signatureData;
  }

  public String getInitialsData() {
    return initialsData;
  }
  public void setInitialsData(String initialsData) {
    this.initialsData = initialsData;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignatureSignatureSettings {\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  companyName: ").append(companyName).append("\n");
    sb.append("  position: ").append(position).append("\n");
    sb.append("  firstName: ").append(firstName).append("\n");
    sb.append("  lastName: ").append(lastName).append("\n");
    sb.append("  textInitials: ").append(textInitials).append("\n");
    sb.append("  signatureData: ").append(signatureData).append("\n");
    sb.append("  initialsData: ").append(initialsData).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

