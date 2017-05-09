package com.zs.entity;

import java.util.ArrayList;
import java.util.List;

public class NoUpdateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NoUpdateExample() {
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

        public Criteria andCourierNumberIsNull() {
            addCriterion("COURIER_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andCourierNumberIsNotNull() {
            addCriterion("COURIER_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andCourierNumberEqualTo(String value) {
            addCriterion("COURIER_NUMBER =", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberNotEqualTo(String value) {
            addCriterion("COURIER_NUMBER <>", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberGreaterThan(String value) {
            addCriterion("COURIER_NUMBER >", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberGreaterThanOrEqualTo(String value) {
            addCriterion("COURIER_NUMBER >=", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberLessThan(String value) {
            addCriterion("COURIER_NUMBER <", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberLessThanOrEqualTo(String value) {
            addCriterion("COURIER_NUMBER <=", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberLike(String value) {
            addCriterion("COURIER_NUMBER like", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberNotLike(String value) {
            addCriterion("COURIER_NUMBER not like", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberIn(List<String> values) {
            addCriterion("COURIER_NUMBER in", values, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberNotIn(List<String> values) {
            addCriterion("COURIER_NUMBER not in", values, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberBetween(String value1, String value2) {
            addCriterion("COURIER_NUMBER between", value1, value2, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberNotBetween(String value1, String value2) {
            addCriterion("COURIER_NUMBER not between", value1, value2, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andNoUpdateNameIsNull() {
            addCriterion("NO_UPDATE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andNoUpdateNameIsNotNull() {
            addCriterion("NO_UPDATE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNoUpdateNameEqualTo(String value) {
            addCriterion("NO_UPDATE_NAME =", value, "noUpdateName");
            return (Criteria) this;
        }

        public Criteria andNoUpdateNameNotEqualTo(String value) {
            addCriterion("NO_UPDATE_NAME <>", value, "noUpdateName");
            return (Criteria) this;
        }

        public Criteria andNoUpdateNameGreaterThan(String value) {
            addCriterion("NO_UPDATE_NAME >", value, "noUpdateName");
            return (Criteria) this;
        }

        public Criteria andNoUpdateNameGreaterThanOrEqualTo(String value) {
            addCriterion("NO_UPDATE_NAME >=", value, "noUpdateName");
            return (Criteria) this;
        }

        public Criteria andNoUpdateNameLessThan(String value) {
            addCriterion("NO_UPDATE_NAME <", value, "noUpdateName");
            return (Criteria) this;
        }

        public Criteria andNoUpdateNameLessThanOrEqualTo(String value) {
            addCriterion("NO_UPDATE_NAME <=", value, "noUpdateName");
            return (Criteria) this;
        }

        public Criteria andNoUpdateNameLike(String value) {
            addCriterion("NO_UPDATE_NAME like", value, "noUpdateName");
            return (Criteria) this;
        }

        public Criteria andNoUpdateNameNotLike(String value) {
            addCriterion("NO_UPDATE_NAME not like", value, "noUpdateName");
            return (Criteria) this;
        }

        public Criteria andNoUpdateNameIn(List<String> values) {
            addCriterion("NO_UPDATE_NAME in", values, "noUpdateName");
            return (Criteria) this;
        }

        public Criteria andNoUpdateNameNotIn(List<String> values) {
            addCriterion("NO_UPDATE_NAME not in", values, "noUpdateName");
            return (Criteria) this;
        }

        public Criteria andNoUpdateNameBetween(String value1, String value2) {
            addCriterion("NO_UPDATE_NAME between", value1, value2, "noUpdateName");
            return (Criteria) this;
        }

        public Criteria andNoUpdateNameNotBetween(String value1, String value2) {
            addCriterion("NO_UPDATE_NAME not between", value1, value2, "noUpdateName");
            return (Criteria) this;
        }

        public Criteria andNoUpdateValueIsNull() {
            addCriterion("NO_UPDATE_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andNoUpdateValueIsNotNull() {
            addCriterion("NO_UPDATE_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andNoUpdateValueEqualTo(String value) {
            addCriterion("NO_UPDATE_VALUE =", value, "noUpdateValue");
            return (Criteria) this;
        }

        public Criteria andNoUpdateValueNotEqualTo(String value) {
            addCriterion("NO_UPDATE_VALUE <>", value, "noUpdateValue");
            return (Criteria) this;
        }

        public Criteria andNoUpdateValueGreaterThan(String value) {
            addCriterion("NO_UPDATE_VALUE >", value, "noUpdateValue");
            return (Criteria) this;
        }

        public Criteria andNoUpdateValueGreaterThanOrEqualTo(String value) {
            addCriterion("NO_UPDATE_VALUE >=", value, "noUpdateValue");
            return (Criteria) this;
        }

        public Criteria andNoUpdateValueLessThan(String value) {
            addCriterion("NO_UPDATE_VALUE <", value, "noUpdateValue");
            return (Criteria) this;
        }

        public Criteria andNoUpdateValueLessThanOrEqualTo(String value) {
            addCriterion("NO_UPDATE_VALUE <=", value, "noUpdateValue");
            return (Criteria) this;
        }

        public Criteria andNoUpdateValueLike(String value) {
            addCriterion("NO_UPDATE_VALUE like", value, "noUpdateValue");
            return (Criteria) this;
        }

        public Criteria andNoUpdateValueNotLike(String value) {
            addCriterion("NO_UPDATE_VALUE not like", value, "noUpdateValue");
            return (Criteria) this;
        }

        public Criteria andNoUpdateValueIn(List<String> values) {
            addCriterion("NO_UPDATE_VALUE in", values, "noUpdateValue");
            return (Criteria) this;
        }

        public Criteria andNoUpdateValueNotIn(List<String> values) {
            addCriterion("NO_UPDATE_VALUE not in", values, "noUpdateValue");
            return (Criteria) this;
        }

        public Criteria andNoUpdateValueBetween(String value1, String value2) {
            addCriterion("NO_UPDATE_VALUE between", value1, value2, "noUpdateValue");
            return (Criteria) this;
        }

        public Criteria andNoUpdateValueNotBetween(String value1, String value2) {
            addCriterion("NO_UPDATE_VALUE not between", value1, value2, "noUpdateValue");
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