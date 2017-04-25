package com.zs.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TimeLimitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TimeLimitExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderNumberIsNull() {
            addCriterion("ORDER_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("ORDER_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(BigDecimal value) {
            addCriterion("ORDER_NUMBER =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(BigDecimal value) {
            addCriterion("ORDER_NUMBER <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(BigDecimal value) {
            addCriterion("ORDER_NUMBER >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDER_NUMBER >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(BigDecimal value) {
            addCriterion("ORDER_NUMBER <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDER_NUMBER <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<BigDecimal> values) {
            addCriterion("ORDER_NUMBER in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<BigDecimal> values) {
            addCriterion("ORDER_NUMBER not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDER_NUMBER between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDER_NUMBER not between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andBeginProvinceIsNull() {
            addCriterion("BEGIN_PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andBeginProvinceIsNotNull() {
            addCriterion("BEGIN_PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andBeginProvinceEqualTo(String value) {
            addCriterion("BEGIN_PROVINCE =", value, "beginProvince");
            return (Criteria) this;
        }

        public Criteria andBeginProvinceNotEqualTo(String value) {
            addCriterion("BEGIN_PROVINCE <>", value, "beginProvince");
            return (Criteria) this;
        }

        public Criteria andBeginProvinceGreaterThan(String value) {
            addCriterion("BEGIN_PROVINCE >", value, "beginProvince");
            return (Criteria) this;
        }

        public Criteria andBeginProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("BEGIN_PROVINCE >=", value, "beginProvince");
            return (Criteria) this;
        }

        public Criteria andBeginProvinceLessThan(String value) {
            addCriterion("BEGIN_PROVINCE <", value, "beginProvince");
            return (Criteria) this;
        }

        public Criteria andBeginProvinceLessThanOrEqualTo(String value) {
            addCriterion("BEGIN_PROVINCE <=", value, "beginProvince");
            return (Criteria) this;
        }

        public Criteria andBeginProvinceLike(String value) {
            addCriterion("BEGIN_PROVINCE like", value, "beginProvince");
            return (Criteria) this;
        }

        public Criteria andBeginProvinceNotLike(String value) {
            addCriterion("BEGIN_PROVINCE not like", value, "beginProvince");
            return (Criteria) this;
        }

        public Criteria andBeginProvinceIn(List<String> values) {
            addCriterion("BEGIN_PROVINCE in", values, "beginProvince");
            return (Criteria) this;
        }

        public Criteria andBeginProvinceNotIn(List<String> values) {
            addCriterion("BEGIN_PROVINCE not in", values, "beginProvince");
            return (Criteria) this;
        }

        public Criteria andBeginProvinceBetween(String value1, String value2) {
            addCriterion("BEGIN_PROVINCE between", value1, value2, "beginProvince");
            return (Criteria) this;
        }

        public Criteria andBeginProvinceNotBetween(String value1, String value2) {
            addCriterion("BEGIN_PROVINCE not between", value1, value2, "beginProvince");
            return (Criteria) this;
        }

        public Criteria andEndProvinceIsNull() {
            addCriterion("END_PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andEndProvinceIsNotNull() {
            addCriterion("END_PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andEndProvinceEqualTo(String value) {
            addCriterion("END_PROVINCE =", value, "endProvince");
            return (Criteria) this;
        }

        public Criteria andEndProvinceNotEqualTo(String value) {
            addCriterion("END_PROVINCE <>", value, "endProvince");
            return (Criteria) this;
        }

        public Criteria andEndProvinceGreaterThan(String value) {
            addCriterion("END_PROVINCE >", value, "endProvince");
            return (Criteria) this;
        }

        public Criteria andEndProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("END_PROVINCE >=", value, "endProvince");
            return (Criteria) this;
        }

        public Criteria andEndProvinceLessThan(String value) {
            addCriterion("END_PROVINCE <", value, "endProvince");
            return (Criteria) this;
        }

        public Criteria andEndProvinceLessThanOrEqualTo(String value) {
            addCriterion("END_PROVINCE <=", value, "endProvince");
            return (Criteria) this;
        }

        public Criteria andEndProvinceLike(String value) {
            addCriterion("END_PROVINCE like", value, "endProvince");
            return (Criteria) this;
        }

        public Criteria andEndProvinceNotLike(String value) {
            addCriterion("END_PROVINCE not like", value, "endProvince");
            return (Criteria) this;
        }

        public Criteria andEndProvinceIn(List<String> values) {
            addCriterion("END_PROVINCE in", values, "endProvince");
            return (Criteria) this;
        }

        public Criteria andEndProvinceNotIn(List<String> values) {
            addCriterion("END_PROVINCE not in", values, "endProvince");
            return (Criteria) this;
        }

        public Criteria andEndProvinceBetween(String value1, String value2) {
            addCriterion("END_PROVINCE between", value1, value2, "endProvince");
            return (Criteria) this;
        }

        public Criteria andEndProvinceNotBetween(String value1, String value2) {
            addCriterion("END_PROVINCE not between", value1, value2, "endProvince");
            return (Criteria) this;
        }

        public Criteria andHourCostIsNull() {
            addCriterion("HOUR_COST is null");
            return (Criteria) this;
        }

        public Criteria andHourCostIsNotNull() {
            addCriterion("HOUR_COST is not null");
            return (Criteria) this;
        }

        public Criteria andHourCostEqualTo(BigDecimal value) {
            addCriterion("HOUR_COST =", value, "hourCost");
            return (Criteria) this;
        }

        public Criteria andHourCostNotEqualTo(BigDecimal value) {
            addCriterion("HOUR_COST <>", value, "hourCost");
            return (Criteria) this;
        }

        public Criteria andHourCostGreaterThan(BigDecimal value) {
            addCriterion("HOUR_COST >", value, "hourCost");
            return (Criteria) this;
        }

        public Criteria andHourCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_COST >=", value, "hourCost");
            return (Criteria) this;
        }

        public Criteria andHourCostLessThan(BigDecimal value) {
            addCriterion("HOUR_COST <", value, "hourCost");
            return (Criteria) this;
        }

        public Criteria andHourCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUR_COST <=", value, "hourCost");
            return (Criteria) this;
        }

        public Criteria andHourCostIn(List<BigDecimal> values) {
            addCriterion("HOUR_COST in", values, "hourCost");
            return (Criteria) this;
        }

        public Criteria andHourCostNotIn(List<BigDecimal> values) {
            addCriterion("HOUR_COST not in", values, "hourCost");
            return (Criteria) this;
        }

        public Criteria andHourCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_COST between", value1, value2, "hourCost");
            return (Criteria) this;
        }

        public Criteria andHourCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUR_COST not between", value1, value2, "hourCost");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}