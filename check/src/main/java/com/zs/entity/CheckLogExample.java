package com.zs.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CheckLogExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<BigDecimal> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeIsNull() {
            addCriterion("LOGISTICCODE is null");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeIsNotNull() {
            addCriterion("LOGISTICCODE is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeEqualTo(String value) {
            addCriterion("LOGISTICCODE =", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeNotEqualTo(String value) {
            addCriterion("LOGISTICCODE <>", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeGreaterThan(String value) {
            addCriterion("LOGISTICCODE >", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeGreaterThanOrEqualTo(String value) {
            addCriterion("LOGISTICCODE >=", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeLessThan(String value) {
            addCriterion("LOGISTICCODE <", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeLessThanOrEqualTo(String value) {
            addCriterion("LOGISTICCODE <=", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeLike(String value) {
            addCriterion("LOGISTICCODE like", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeNotLike(String value) {
            addCriterion("LOGISTICCODE not like", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeIn(List<String> values) {
            addCriterion("LOGISTICCODE in", values, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeNotIn(List<String> values) {
            addCriterion("LOGISTICCODE not in", values, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeBetween(String value1, String value2) {
            addCriterion("LOGISTICCODE between", value1, value2, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeNotBetween(String value1, String value2) {
            addCriterion("LOGISTICCODE not between", value1, value2, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andIdDateIsNull() {
            addCriterion("ID_DATE is null");
            return (Criteria) this;
        }

        public Criteria andIdDateIsNotNull() {
            addCriterion("ID_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andIdDateEqualTo(Date value) {
            addCriterion("ID_DATE =", value, "idDate");
            return (Criteria) this;
        }

        public Criteria andIdDateNotEqualTo(Date value) {
            addCriterion("ID_DATE <>", value, "idDate");
            return (Criteria) this;
        }

        public Criteria andIdDateGreaterThan(Date value) {
            addCriterion("ID_DATE >", value, "idDate");
            return (Criteria) this;
        }

        public Criteria andIdDateGreaterThanOrEqualTo(Date value) {
            addCriterion("ID_DATE >=", value, "idDate");
            return (Criteria) this;
        }

        public Criteria andIdDateLessThan(Date value) {
            addCriterion("ID_DATE <", value, "idDate");
            return (Criteria) this;
        }

        public Criteria andIdDateLessThanOrEqualTo(Date value) {
            addCriterion("ID_DATE <=", value, "idDate");
            return (Criteria) this;
        }

        public Criteria andIdDateIn(List<Date> values) {
            addCriterion("ID_DATE in", values, "idDate");
            return (Criteria) this;
        }

        public Criteria andIdDateNotIn(List<Date> values) {
            addCriterion("ID_DATE not in", values, "idDate");
            return (Criteria) this;
        }

        public Criteria andIdDateBetween(Date value1, Date value2) {
            addCriterion("ID_DATE between", value1, value2, "idDate");
            return (Criteria) this;
        }

        public Criteria andIdDateNotBetween(Date value1, Date value2) {
            addCriterion("ID_DATE not between", value1, value2, "idDate");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNull() {
            addCriterion("TABLENAME is null");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNotNull() {
            addCriterion("TABLENAME is not null");
            return (Criteria) this;
        }

        public Criteria andTablenameEqualTo(String value) {
            addCriterion("TABLENAME =", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotEqualTo(String value) {
            addCriterion("TABLENAME <>", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThan(String value) {
            addCriterion("TABLENAME >", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThanOrEqualTo(String value) {
            addCriterion("TABLENAME >=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThan(String value) {
            addCriterion("TABLENAME <", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThanOrEqualTo(String value) {
            addCriterion("TABLENAME <=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLike(String value) {
            addCriterion("TABLENAME like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotLike(String value) {
            addCriterion("TABLENAME not like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameIn(List<String> values) {
            addCriterion("TABLENAME in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotIn(List<String> values) {
            addCriterion("TABLENAME not in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameBetween(String value1, String value2) {
            addCriterion("TABLENAME between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotBetween(String value1, String value2) {
            addCriterion("TABLENAME not between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andOlddataIsNull() {
            addCriterion("OLDDATA is null");
            return (Criteria) this;
        }

        public Criteria andOlddataIsNotNull() {
            addCriterion("OLDDATA is not null");
            return (Criteria) this;
        }

        public Criteria andOlddataEqualTo(String value) {
            addCriterion("OLDDATA =", value, "olddata");
            return (Criteria) this;
        }

        public Criteria andOlddataNotEqualTo(String value) {
            addCriterion("OLDDATA <>", value, "olddata");
            return (Criteria) this;
        }

        public Criteria andOlddataGreaterThan(String value) {
            addCriterion("OLDDATA >", value, "olddata");
            return (Criteria) this;
        }

        public Criteria andOlddataGreaterThanOrEqualTo(String value) {
            addCriterion("OLDDATA >=", value, "olddata");
            return (Criteria) this;
        }

        public Criteria andOlddataLessThan(String value) {
            addCriterion("OLDDATA <", value, "olddata");
            return (Criteria) this;
        }

        public Criteria andOlddataLessThanOrEqualTo(String value) {
            addCriterion("OLDDATA <=", value, "olddata");
            return (Criteria) this;
        }

        public Criteria andOlddataLike(String value) {
            addCriterion("OLDDATA like", value, "olddata");
            return (Criteria) this;
        }

        public Criteria andOlddataNotLike(String value) {
            addCriterion("OLDDATA not like", value, "olddata");
            return (Criteria) this;
        }

        public Criteria andOlddataIn(List<String> values) {
            addCriterion("OLDDATA in", values, "olddata");
            return (Criteria) this;
        }

        public Criteria andOlddataNotIn(List<String> values) {
            addCriterion("OLDDATA not in", values, "olddata");
            return (Criteria) this;
        }

        public Criteria andOlddataBetween(String value1, String value2) {
            addCriterion("OLDDATA between", value1, value2, "olddata");
            return (Criteria) this;
        }

        public Criteria andOlddataNotBetween(String value1, String value2) {
            addCriterion("OLDDATA not between", value1, value2, "olddata");
            return (Criteria) this;
        }

        public Criteria andCretetimeIsNull() {
            addCriterion("CRETETIME is null");
            return (Criteria) this;
        }

        public Criteria andCretetimeIsNotNull() {
            addCriterion("CRETETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCretetimeEqualTo(Date value) {
            addCriterion("CRETETIME =", value, "cretetime");
            return (Criteria) this;
        }

        public Criteria andCretetimeNotEqualTo(Date value) {
            addCriterion("CRETETIME <>", value, "cretetime");
            return (Criteria) this;
        }

        public Criteria andCretetimeGreaterThan(Date value) {
            addCriterion("CRETETIME >", value, "cretetime");
            return (Criteria) this;
        }

        public Criteria andCretetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CRETETIME >=", value, "cretetime");
            return (Criteria) this;
        }

        public Criteria andCretetimeLessThan(Date value) {
            addCriterion("CRETETIME <", value, "cretetime");
            return (Criteria) this;
        }

        public Criteria andCretetimeLessThanOrEqualTo(Date value) {
            addCriterion("CRETETIME <=", value, "cretetime");
            return (Criteria) this;
        }

        public Criteria andCretetimeIn(List<Date> values) {
            addCriterion("CRETETIME in", values, "cretetime");
            return (Criteria) this;
        }

        public Criteria andCretetimeNotIn(List<Date> values) {
            addCriterion("CRETETIME not in", values, "cretetime");
            return (Criteria) this;
        }

        public Criteria andCretetimeBetween(Date value1, Date value2) {
            addCriterion("CRETETIME between", value1, value2, "cretetime");
            return (Criteria) this;
        }

        public Criteria andCretetimeNotBetween(Date value1, Date value2) {
            addCriterion("CRETETIME not between", value1, value2, "cretetime");
            return (Criteria) this;
        }

        public Criteria andUserNumberIsNull() {
            addCriterion("USER_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andUserNumberIsNotNull() {
            addCriterion("USER_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andUserNumberEqualTo(String value) {
            addCriterion("USER_NUMBER =", value, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberNotEqualTo(String value) {
            addCriterion("USER_NUMBER <>", value, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberGreaterThan(String value) {
            addCriterion("USER_NUMBER >", value, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NUMBER >=", value, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberLessThan(String value) {
            addCriterion("USER_NUMBER <", value, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberLessThanOrEqualTo(String value) {
            addCriterion("USER_NUMBER <=", value, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberLike(String value) {
            addCriterion("USER_NUMBER like", value, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberNotLike(String value) {
            addCriterion("USER_NUMBER not like", value, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberIn(List<String> values) {
            addCriterion("USER_NUMBER in", values, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberNotIn(List<String> values) {
            addCriterion("USER_NUMBER not in", values, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberBetween(String value1, String value2) {
            addCriterion("USER_NUMBER between", value1, value2, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberNotBetween(String value1, String value2) {
            addCriterion("USER_NUMBER not between", value1, value2, "userNumber");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
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