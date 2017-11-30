package com.performance.model;

public class TblModuleRule {
    private Integer id;

    private Integer generatorKey;

    private Integer moduleKey;

    private String moduleName;

    private Integer paramType;

    private Integer paramIndex;

    private Integer ruleKey;

    private String ruleName;

    private Integer startIndex;

    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGeneratorKey() {
        return generatorKey;
    }

    public void setGeneratorKey(Integer generatorKey) {
        this.generatorKey = generatorKey;
    }

    public Integer getModuleKey() {
        return moduleKey;
    }

    public void setModuleKey(Integer moduleKey) {
        this.moduleKey = moduleKey;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public Integer getParamType() {
        return paramType;
    }

    public void setParamType(Integer paramType) {
        this.paramType = paramType;
    }

    public Integer getParamIndex() {
        return paramIndex;
    }

    public void setParamIndex(Integer paramIndex) {
        this.paramIndex = paramIndex;
    }

    public Integer getRuleKey() {
        return ruleKey;
    }

    public void setRuleKey(Integer ruleKey) {
        this.ruleKey = ruleKey;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName == null ? null : ruleName.trim();
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}