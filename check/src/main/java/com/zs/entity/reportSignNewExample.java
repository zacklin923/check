package com.zs.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class reportSignNewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public reportSignNewExample() {
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

        public Criteria andIdentifyIsNull() {
            addCriterion("IDENTIFY is null");
            return (Criteria) this;
        }

        public Criteria andIdentifyIsNotNull() {
            addCriterion("IDENTIFY is not null");
            return (Criteria) this;
        }

        public Criteria andIdentifyEqualTo(String value) {
            addCriterion("IDENTIFY =", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyNotEqualTo(String value) {
            addCriterion("IDENTIFY <>", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyGreaterThan(String value) {
            addCriterion("IDENTIFY >", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyGreaterThanOrEqualTo(String value) {
            addCriterion("IDENTIFY >=", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyLessThan(String value) {
            addCriterion("IDENTIFY <", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyLessThanOrEqualTo(String value) {
            addCriterion("IDENTIFY <=", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyLike(String value) {
            addCriterion("IDENTIFY like", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyNotLike(String value) {
            addCriterion("IDENTIFY not like", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyIn(List<String> values) {
            addCriterion("IDENTIFY in", values, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyNotIn(List<String> values) {
            addCriterion("IDENTIFY not in", values, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyBetween(String value1, String value2) {
            addCriterion("IDENTIFY between", value1, value2, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyNotBetween(String value1, String value2) {
            addCriterion("IDENTIFY not between", value1, value2, "identify");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("FLAG =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("FLAG <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("FLAG >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("FLAG >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("FLAG <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("FLAG <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("FLAG like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("FLAG not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("FLAG in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("FLAG not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("FLAG between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("FLAG not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andCountDateIsNull() {
            addCriterion("COUNT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCountDateIsNotNull() {
            addCriterion("COUNT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCountDateEqualTo(Date value) {
            addCriterion("COUNT_DATE =", value, "countDate");
            return (Criteria) this;
        }

        public Criteria andCountDateNotEqualTo(Date value) {
            addCriterion("COUNT_DATE <>", value, "countDate");
            return (Criteria) this;
        }

        public Criteria andCountDateGreaterThan(Date value) {
            addCriterion("COUNT_DATE >", value, "countDate");
            return (Criteria) this;
        }

        public Criteria andCountDateGreaterThanOrEqualTo(Date value) {
            addCriterion("COUNT_DATE >=", value, "countDate");
            return (Criteria) this;
        }

        public Criteria andCountDateLessThan(Date value) {
            addCriterion("COUNT_DATE <", value, "countDate");
            return (Criteria) this;
        }

        public Criteria andCountDateLessThanOrEqualTo(Date value) {
            addCriterion("COUNT_DATE <=", value, "countDate");
            return (Criteria) this;
        }

        public Criteria andCountDateIn(List<Date> values) {
            addCriterion("COUNT_DATE in", values, "countDate");
            return (Criteria) this;
        }

        public Criteria andCountDateNotIn(List<Date> values) {
            addCriterion("COUNT_DATE not in", values, "countDate");
            return (Criteria) this;
        }

        public Criteria andCountDateBetween(Date value1, Date value2) {
            addCriterion("COUNT_DATE between", value1, value2, "countDate");
            return (Criteria) this;
        }

        public Criteria andCountDateNotBetween(Date value1, Date value2) {
            addCriterion("COUNT_DATE not between", value1, value2, "countDate");
            return (Criteria) this;
        }

        public Criteria andSuccCountIsNull() {
            addCriterion("SUCC_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andSuccCountIsNotNull() {
            addCriterion("SUCC_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSuccCountEqualTo(BigDecimal value) {
            addCriterion("SUCC_COUNT =", value, "succCount");
            return (Criteria) this;
        }

        public Criteria andSuccCountNotEqualTo(BigDecimal value) {
            addCriterion("SUCC_COUNT <>", value, "succCount");
            return (Criteria) this;
        }

        public Criteria andSuccCountGreaterThan(BigDecimal value) {
            addCriterion("SUCC_COUNT >", value, "succCount");
            return (Criteria) this;
        }

        public Criteria andSuccCountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUCC_COUNT >=", value, "succCount");
            return (Criteria) this;
        }

        public Criteria andSuccCountLessThan(BigDecimal value) {
            addCriterion("SUCC_COUNT <", value, "succCount");
            return (Criteria) this;
        }

        public Criteria andSuccCountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUCC_COUNT <=", value, "succCount");
            return (Criteria) this;
        }

        public Criteria andSuccCountIn(List<BigDecimal> values) {
            addCriterion("SUCC_COUNT in", values, "succCount");
            return (Criteria) this;
        }

        public Criteria andSuccCountNotIn(List<BigDecimal> values) {
            addCriterion("SUCC_COUNT not in", values, "succCount");
            return (Criteria) this;
        }

        public Criteria andSuccCountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUCC_COUNT between", value1, value2, "succCount");
            return (Criteria) this;
        }

        public Criteria andSuccCountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUCC_COUNT not between", value1, value2, "succCount");
            return (Criteria) this;
        }

        public Criteria andAllCountIsNull() {
            addCriterion("ALL_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andAllCountIsNotNull() {
            addCriterion("ALL_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAllCountEqualTo(BigDecimal value) {
            addCriterion("ALL_COUNT =", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountNotEqualTo(BigDecimal value) {
            addCriterion("ALL_COUNT <>", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountGreaterThan(BigDecimal value) {
            addCriterion("ALL_COUNT >", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ALL_COUNT >=", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountLessThan(BigDecimal value) {
            addCriterion("ALL_COUNT <", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ALL_COUNT <=", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountIn(List<BigDecimal> values) {
            addCriterion("ALL_COUNT in", values, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountNotIn(List<BigDecimal> values) {
            addCriterion("ALL_COUNT not in", values, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ALL_COUNT between", value1, value2, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ALL_COUNT not between", value1, value2, "allCount");
            return (Criteria) this;
        }

        public Criteria andTimeOutCountIsNull() {
            addCriterion("TIME_OUT_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andTimeOutCountIsNotNull() {
            addCriterion("TIME_OUT_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTimeOutCountEqualTo(BigDecimal value) {
            addCriterion("TIME_OUT_COUNT =", value, "timeOutCount");
            return (Criteria) this;
        }

        public Criteria andTimeOutCountNotEqualTo(BigDecimal value) {
            addCriterion("TIME_OUT_COUNT <>", value, "timeOutCount");
            return (Criteria) this;
        }

        public Criteria andTimeOutCountGreaterThan(BigDecimal value) {
            addCriterion("TIME_OUT_COUNT >", value, "timeOutCount");
            return (Criteria) this;
        }

        public Criteria andTimeOutCountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TIME_OUT_COUNT >=", value, "timeOutCount");
            return (Criteria) this;
        }

        public Criteria andTimeOutCountLessThan(BigDecimal value) {
            addCriterion("TIME_OUT_COUNT <", value, "timeOutCount");
            return (Criteria) this;
        }

        public Criteria andTimeOutCountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TIME_OUT_COUNT <=", value, "timeOutCount");
            return (Criteria) this;
        }

        public Criteria andTimeOutCountIn(List<BigDecimal> values) {
            addCriterion("TIME_OUT_COUNT in", values, "timeOutCount");
            return (Criteria) this;
        }

        public Criteria andTimeOutCountNotIn(List<BigDecimal> values) {
            addCriterion("TIME_OUT_COUNT not in", values, "timeOutCount");
            return (Criteria) this;
        }

        public Criteria andTimeOutCountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TIME_OUT_COUNT between", value1, value2, "timeOutCount");
            return (Criteria) this;
        }

        public Criteria andTimeOutCountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TIME_OUT_COUNT not between", value1, value2, "timeOutCount");
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