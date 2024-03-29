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
public class SignatureFieldInfo {
  private String id = null;
  private String name = null;
  private Integer graphSizeW = null;
  private Integer graphSizeH = null;
  private String getDataFrom = null;
  private String regularExpression = null;
  private String fontName = null;
  private String fontColor = null;
  private Double fontSize = null;
  private Boolean fontBold = null;
  private Boolean fontItalic = null;
  private Boolean fontUnderline = null;
  private Boolean isSystem = null;
  private Integer fieldType = null;
  private String acceptableValues = null;
  private String defaultValue = null;
  private Integer align = null;
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public Integer getGraphSizeW() {
    return graphSizeW;
  }
  public void setGraphSizeW(Integer graphSizeW) {
    this.graphSizeW = graphSizeW;
  }

  public Integer getGraphSizeH() {
    return graphSizeH;
  }
  public void setGraphSizeH(Integer graphSizeH) {
    this.graphSizeH = graphSizeH;
  }

  public String getGetDataFrom() {
    return getDataFrom;
  }
  public void setGetDataFrom(String getDataFrom) {
    this.getDataFrom = getDataFrom;
  }

  public String getRegularExpression() {
    return regularExpression;
  }
  public void setRegularExpression(String regularExpression) {
    this.regularExpression = regularExpression;
  }

  public String getFontName() {
    return fontName;
  }
  public void setFontName(String fontName) {
    this.fontName = fontName;
  }

  public String getFontColor() {
    return fontColor;
  }
  public void setFontColor(String fontColor) {
    this.fontColor = fontColor;
  }

  public Double getFontSize() {
    return fontSize;
  }
  public void setFontSize(Double fontSize) {
    this.fontSize = fontSize;
  }

  public Boolean getFontBold() {
    return fontBold;
  }
  public void setFontBold(Boolean fontBold) {
    this.fontBold = fontBold;
  }

  public Boolean getFontItalic() {
    return fontItalic;
  }
  public void setFontItalic(Boolean fontItalic) {
    this.fontItalic = fontItalic;
  }

  public Boolean getFontUnderline() {
    return fontUnderline;
  }
  public void setFontUnderline(Boolean fontUnderline) {
    this.fontUnderline = fontUnderline;
  }

  public Boolean getIsSystem() {
    return isSystem;
  }
  public void setIsSystem(Boolean isSystem) {
    this.isSystem = isSystem;
  }

  public Integer getFieldType() {
    return fieldType;
  }
  public void setFieldType(Integer fieldType) {
    this.fieldType = fieldType;
  }

  public String getAcceptableValues() {
    return acceptableValues;
  }
  public void setAcceptableValues(String acceptableValues) {
    this.acceptableValues = acceptableValues;
  }

  public String getDefaultValue() {
    return defaultValue;
  }
  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }

  public Integer getAlign() {
    return align;
  }
  public void setAlign(Integer align) {
    this.align = align;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignatureFieldInfo {\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  graphSizeW: ").append(graphSizeW).append("\n");
    sb.append("  graphSizeH: ").append(graphSizeH).append("\n");
    sb.append("  getDataFrom: ").append(getDataFrom).append("\n");
    sb.append("  regularExpression: ").append(regularExpression).append("\n");
    sb.append("  fontName: ").append(fontName).append("\n");
    sb.append("  fontColor: ").append(fontColor).append("\n");
    sb.append("  fontSize: ").append(fontSize).append("\n");
    sb.append("  fontBold: ").append(fontBold).append("\n");
    sb.append("  fontItalic: ").append(fontItalic).append("\n");
    sb.append("  fontUnderline: ").append(fontUnderline).append("\n");
    sb.append("  isSystem: ").append(isSystem).append("\n");
    sb.append("  fieldType: ").append(fieldType).append("\n");
    sb.append("  acceptableValues: ").append(acceptableValues).append("\n");
    sb.append("  defaultValue: ").append(defaultValue).append("\n");
    sb.append("  align: ").append(align).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

