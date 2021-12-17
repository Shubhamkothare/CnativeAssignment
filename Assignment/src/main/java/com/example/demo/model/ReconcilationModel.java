package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReconcilationModel {

	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;
	    
	    
	    @Column(name = "RuleName")
		String ruleName;
		
		@Column(name = "RuleVersion")
		String ruleVersion;
		
		@Column(name = "RulePriority")
		Integer rulePriority;
		
		@Column(name = "IsActive")
		Boolean isActive;
		
		
		@Column(name = "fielddata")
		String fielddata;
		
		@Column(name = "Conditiondata")
		String conditiondata;
		
		@Column(name = "Valuedata")
		String valuedata;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getRuleName() {
			return ruleName;
		}

		public void setRuleName(String ruleName) {
			this.ruleName = ruleName;
		}

		public String getRuleVersion() {
			return ruleVersion;
		}

		public void setRuleVersion(String ruleVersion) {
			this.ruleVersion = ruleVersion;
		}

		public Integer getRulePriority() {
			return rulePriority;
		}

		public void setRulePriority(Integer rulePriority) {
			this.rulePriority = rulePriority;
		}

		public Boolean getIsActive() {
			return isActive;
		}

		public void setIsActive(Boolean isActive) {
			this.isActive = isActive;
		}

		public String getFielddata() {
			return fielddata;
		}

		public void setFielddata(String fielddata) {
			this.fielddata = fielddata;
		}

		public String getConditiondata() {
			return conditiondata;
		}

		public void setConditiondata(String conditiondata) {
			this.conditiondata = conditiondata;
		}

		public String getValuedata() {
			return valuedata;
		}

		public void setValuedata(String valuedata) {
			this.valuedata = valuedata;
		}
}
