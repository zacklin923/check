package com.zs.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SourceImportFailedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SourceImportFailedExample() {
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

        public Criteria andSifIdIsNull() {
            addCriterion("SIF_ID is null");
            return (Criteria) this;
        }

        public Criteria andSifIdIsNotNull() {
            addCriterion("SIF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSifIdEqualTo(BigDecimal value) {
            addCriterion("SIF_ID =", value, "sifId");
            return (Criteria) this;
        }

        public Criteria andSifIdNotEqualTo(BigDecimal value) {
            addCriterion("SIF_ID <>", value, "sifId");
            return (Criteria) this;
        }

        public Criteria andSifIdGreaterThan(BigDecimal value) {
            addCriterion("SIF_ID >", value, "sifId");
            return (Criteria) this;
        }

        public Criteria andSifIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SIF_ID >=", value, "sifId");
            return (Criteria) this;
        }

        public Criteria andSifIdLessThan(BigDecimal value) {
            addCriterion("SIF_ID <", value, "sifId");
            return (Criteria) this;
        }

        public Criteria andSifIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SIF_ID <=", value, "sifId");
            return (Criteria) this;
        }

        public Criteria andSifIdIn(List<BigDecimal> values) {
            addCriterion("SIF_ID in", values, "sifId");
            return (Criteria) this;
        }

        public Criteria andSifIdNotIn(List<BigDecimal> values) {
            addCriterion("SIF_ID not in", values, "sifId");
            return (Criteria) this;
        }

        public Criteria andSifIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SIF_ID between", value1, value2, "sifId");
            return (Criteria) this;
        }

        public Criteria andSifIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SIF_ID not between", value1, value2, "sifId");
            return (Criteria) this;
        }

        public Criteria andStuNumIsNull() {
            addCriterion("STU_NUM is null");
            return (Criteria) this;
        }

        public Criteria andStuNumIsNotNull() {
            addCriterion("STU_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andStuNumEqualTo(String value) {
            addCriterion("STU_NUM =", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumNotEqualTo(String value) {
            addCriterion("STU_NUM <>", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumGreaterThan(String value) {
            addCriterion("STU_NUM >", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumGreaterThanOrEqualTo(String value) {
            addCriterion("STU_NUM >=", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumLessThan(String value) {
            addCriterion("STU_NUM <", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumLessThanOrEqualTo(String value) {
            addCriterion("STU_NUM <=", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumLike(String value) {
            addCriterion("STU_NUM like", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumNotLike(String value) {
            addCriterion("STU_NUM not like", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumIn(List<String> values) {
            addCriterion("STU_NUM in", values, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumNotIn(List<String> values) {
            addCriterion("STU_NUM not in", values, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumBetween(String value1, String value2) {
            addCriterion("STU_NUM between", value1, value2, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumNotBetween(String value1, String value2) {
            addCriterion("STU_NUM not between", value1, value2, "stuNum");
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

        public Criteria andFailInfoIsNull() {
            addCriterion("FAIL_INFO is null");
            return (Criteria) this;
        }

        public Criteria andFailInfoIsNotNull() {
            addCriterion("FAIL_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andFailInfoEqualTo(String value) {
            addCriterion("FAIL_INFO =", value, "failInfo");
            return (Criteria) this;
        }

        public Criteria andFailInfoNotEqualTo(String value) {
            addCriterion("FAIL_INFO <>", value, "failInfo");
            return (Criteria) this;
        }

        public Criteria andFailInfoGreaterThan(String value) {
            addCriterion("FAIL_INFO >", value, "failInfo");
            return (Criteria) this;
        }

        public Criteria andFailInfoGreaterThanOrEqualTo(String value) {
            addCriterion("FAIL_INFO >=", value, "failInfo");
            return (Criteria) this;
        }

        public Criteria andFailInfoLessThan(String value) {
            addCriterion("FAIL_INFO <", value, "failInfo");
            return (Criteria) this;
        }

        public Criteria andFailInfoLessThanOrEqualTo(String value) {
            addCriterion("FAIL_INFO <=", value, "failInfo");
            return (Criteria) this;
        }

        public Criteria andFailInfoLike(String value) {
            addCriterion("FAIL_INFO like", value, "failInfo");
            return (Criteria) this;
        }

        public Criteria andFailInfoNotLike(String value) {
            addCriterion("FAIL_INFO not like", value, "failInfo");
            return (Criteria) this;
        }

        public Criteria andFailInfoIn(List<String> values) {
            addCriterion("FAIL_INFO in", values, "failInfo");
            return (Criteria) this;
        }

        public Criteria andFailInfoNotIn(List<String> values) {
            addCriterion("FAIL_INFO not in", values, "failInfo");
            return (Criteria) this;
        }

        public Criteria andFailInfoBetween(String value1, String value2) {
            addCriterion("FAIL_INFO between", value1, value2, "failInfo");
            return (Criteria) this;
        }

        public Criteria andFailInfoNotBetween(String value1, String value2) {
            addCriterion("FAIL_INFO not between", value1, value2, "failInfo");
            return (Criteria) this;
        }

        public Criteria andFailTypeIsNull() {
            addCriterion("FAIL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFailTypeIsNotNull() {
            addCriterion("FAIL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFailTypeEqualTo(String value) {
            addCriterion("FAIL_TYPE =", value, "failType");
            return (Criteria) this;
        }

        public Criteria andFailTypeNotEqualTo(String value) {
            addCriterion("FAIL_TYPE <>", value, "failType");
            return (Criteria) this;
        }

        public Criteria andFailTypeGreaterThan(String value) {
            addCriterion("FAIL_TYPE >", value, "failType");
            return (Criteria) this;
        }

        public Criteria andFailTypeGreaterThanOrEqualTo(String value) {
            addCriterion("FAIL_TYPE >=", value, "failType");
            return (Criteria) this;
        }

        public Criteria andFailTypeLessThan(String value) {
            addCriterion("FAIL_TYPE <", value, "failType");
            return (Criteria) this;
        }

        public Criteria andFailTypeLessThanOrEqualTo(String value) {
            addCriterion("FAIL_TYPE <=", value, "failType");
            return (Criteria) this;
        }

        public Criteria andFailTypeLike(String value) {
            addCriterion("FAIL_TYPE like", value, "failType");
            return (Criteria) this;
        }

        public Criteria andFailTypeNotLike(String value) {
            addCriterion("FAIL_TYPE not like", value, "failType");
            return (Criteria) this;
        }

        public Criteria andFailTypeIn(List<String> values) {
            addCriterion("FAIL_TYPE in", values, "failType");
            return (Criteria) this;
        }

        public Criteria andFailTypeNotIn(List<String> values) {
            addCriterion("FAIL_TYPE not in", values, "failType");
            return (Criteria) this;
        }

        public Criteria andFailTypeBetween(String value1, String value2) {
            addCriterion("FAIL_TYPE between", value1, value2, "failType");
            return (Criteria) this;
        }

        public Criteria andFailTypeNotBetween(String value1, String value2) {
            addCriterion("FAIL_TYPE not between", value1, value2, "failType");
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