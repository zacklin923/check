package com.zs.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StaffPowerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StaffPowerExample() {
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

        public Criteria andStpIdIsNull() {
            addCriterion("STP_ID is null");
            return (Criteria) this;
        }

        public Criteria andStpIdIsNotNull() {
            addCriterion("STP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStpIdEqualTo(BigDecimal value) {
            addCriterion("STP_ID =", value, "stpId");
            return (Criteria) this;
        }

        public Criteria andStpIdNotEqualTo(BigDecimal value) {
            addCriterion("STP_ID <>", value, "stpId");
            return (Criteria) this;
        }

        public Criteria andStpIdGreaterThan(BigDecimal value) {
            addCriterion("STP_ID >", value, "stpId");
            return (Criteria) this;
        }

        public Criteria andStpIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STP_ID >=", value, "stpId");
            return (Criteria) this;
        }

        public Criteria andStpIdLessThan(BigDecimal value) {
            addCriterion("STP_ID <", value, "stpId");
            return (Criteria) this;
        }

        public Criteria andStpIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STP_ID <=", value, "stpId");
            return (Criteria) this;
        }

        public Criteria andStpIdIn(List<BigDecimal> values) {
            addCriterion("STP_ID in", values, "stpId");
            return (Criteria) this;
        }

        public Criteria andStpIdNotIn(List<BigDecimal> values) {
            addCriterion("STP_ID not in", values, "stpId");
            return (Criteria) this;
        }

        public Criteria andStpIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STP_ID between", value1, value2, "stpId");
            return (Criteria) this;
        }

        public Criteria andStpIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STP_ID not between", value1, value2, "stpId");
            return (Criteria) this;
        }

        public Criteria andStpNameIsNull() {
            addCriterion("STP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStpNameIsNotNull() {
            addCriterion("STP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStpNameEqualTo(String value) {
            addCriterion("STP_NAME =", value, "stpName");
            return (Criteria) this;
        }

        public Criteria andStpNameNotEqualTo(String value) {
            addCriterion("STP_NAME <>", value, "stpName");
            return (Criteria) this;
        }

        public Criteria andStpNameGreaterThan(String value) {
            addCriterion("STP_NAME >", value, "stpName");
            return (Criteria) this;
        }

        public Criteria andStpNameGreaterThanOrEqualTo(String value) {
            addCriterion("STP_NAME >=", value, "stpName");
            return (Criteria) this;
        }

        public Criteria andStpNameLessThan(String value) {
            addCriterion("STP_NAME <", value, "stpName");
            return (Criteria) this;
        }

        public Criteria andStpNameLessThanOrEqualTo(String value) {
            addCriterion("STP_NAME <=", value, "stpName");
            return (Criteria) this;
        }

        public Criteria andStpNameLike(String value) {
            addCriterion("STP_NAME like", value, "stpName");
            return (Criteria) this;
        }

        public Criteria andStpNameNotLike(String value) {
            addCriterion("STP_NAME not like", value, "stpName");
            return (Criteria) this;
        }

        public Criteria andStpNameIn(List<String> values) {
            addCriterion("STP_NAME in", values, "stpName");
            return (Criteria) this;
        }

        public Criteria andStpNameNotIn(List<String> values) {
            addCriterion("STP_NAME not in", values, "stpName");
            return (Criteria) this;
        }

        public Criteria andStpNameBetween(String value1, String value2) {
            addCriterion("STP_NAME between", value1, value2, "stpName");
            return (Criteria) this;
        }

        public Criteria andStpNameNotBetween(String value1, String value2) {
            addCriterion("STP_NAME not between", value1, value2, "stpName");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
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