package com.zs.entity;

import java.util.ArrayList;
import java.util.List;

public class CustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerExample() {
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

        public Criteria andCteBarCodeIsNull() {
            addCriterion("CTE_BAR_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeIsNotNull() {
            addCriterion("CTE_BAR_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeEqualTo(String value) {
            addCriterion("CTE_BAR_CODE =", value, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeNotEqualTo(String value) {
            addCriterion("CTE_BAR_CODE <>", value, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeGreaterThan(String value) {
            addCriterion("CTE_BAR_CODE >", value, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CTE_BAR_CODE >=", value, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeLessThan(String value) {
            addCriterion("CTE_BAR_CODE <", value, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeLessThanOrEqualTo(String value) {
            addCriterion("CTE_BAR_CODE <=", value, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeLike(String value) {
            addCriterion("CTE_BAR_CODE like", value, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeNotLike(String value) {
            addCriterion("CTE_BAR_CODE not like", value, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeIn(List<String> values) {
            addCriterion("CTE_BAR_CODE in", values, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeNotIn(List<String> values) {
            addCriterion("CTE_BAR_CODE not in", values, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeBetween(String value1, String value2) {
            addCriterion("CTE_BAR_CODE between", value1, value2, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteBarCodeNotBetween(String value1, String value2) {
            addCriterion("CTE_BAR_CODE not between", value1, value2, "cteBarCode");
            return (Criteria) this;
        }

        public Criteria andCteNameIsNull() {
            addCriterion("CTE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCteNameIsNotNull() {
            addCriterion("CTE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCteNameEqualTo(String value) {
            addCriterion("CTE_NAME =", value, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameNotEqualTo(String value) {
            addCriterion("CTE_NAME <>", value, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameGreaterThan(String value) {
            addCriterion("CTE_NAME >", value, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameGreaterThanOrEqualTo(String value) {
            addCriterion("CTE_NAME >=", value, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameLessThan(String value) {
            addCriterion("CTE_NAME <", value, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameLessThanOrEqualTo(String value) {
            addCriterion("CTE_NAME <=", value, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameLike(String value) {
            addCriterion("CTE_NAME like", value, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameNotLike(String value) {
            addCriterion("CTE_NAME not like", value, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameIn(List<String> values) {
            addCriterion("CTE_NAME in", values, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameNotIn(List<String> values) {
            addCriterion("CTE_NAME not in", values, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameBetween(String value1, String value2) {
            addCriterion("CTE_NAME between", value1, value2, "cteName");
            return (Criteria) this;
        }

        public Criteria andCteNameNotBetween(String value1, String value2) {
            addCriterion("CTE_NAME not between", value1, value2, "cteName");
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