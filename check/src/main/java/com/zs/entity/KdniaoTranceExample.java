package com.zs.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KdniaoTranceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KdniaoTranceExample() {
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

        public Criteria andAcceptTimeIsNull() {
            addCriterion("ACCEPT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIsNotNull() {
            addCriterion("ACCEPT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeEqualTo(Date value) {
            addCriterion("ACCEPT_TIME =", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotEqualTo(Date value) {
            addCriterion("ACCEPT_TIME <>", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeGreaterThan(Date value) {
            addCriterion("ACCEPT_TIME >", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ACCEPT_TIME >=", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeLessThan(Date value) {
            addCriterion("ACCEPT_TIME <", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeLessThanOrEqualTo(Date value) {
            addCriterion("ACCEPT_TIME <=", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIn(List<Date> values) {
            addCriterion("ACCEPT_TIME in", values, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotIn(List<Date> values) {
            addCriterion("ACCEPT_TIME not in", values, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeBetween(Date value1, Date value2) {
            addCriterion("ACCEPT_TIME between", value1, value2, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotBetween(Date value1, Date value2) {
            addCriterion("ACCEPT_TIME not between", value1, value2, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptStationIsNull() {
            addCriterion("ACCEPT_STATION is null");
            return (Criteria) this;
        }

        public Criteria andAcceptStationIsNotNull() {
            addCriterion("ACCEPT_STATION is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptStationEqualTo(String value) {
            addCriterion("ACCEPT_STATION =", value, "acceptStation");
            return (Criteria) this;
        }

        public Criteria andAcceptStationNotEqualTo(String value) {
            addCriterion("ACCEPT_STATION <>", value, "acceptStation");
            return (Criteria) this;
        }

        public Criteria andAcceptStationGreaterThan(String value) {
            addCriterion("ACCEPT_STATION >", value, "acceptStation");
            return (Criteria) this;
        }

        public Criteria andAcceptStationGreaterThanOrEqualTo(String value) {
            addCriterion("ACCEPT_STATION >=", value, "acceptStation");
            return (Criteria) this;
        }

        public Criteria andAcceptStationLessThan(String value) {
            addCriterion("ACCEPT_STATION <", value, "acceptStation");
            return (Criteria) this;
        }

        public Criteria andAcceptStationLessThanOrEqualTo(String value) {
            addCriterion("ACCEPT_STATION <=", value, "acceptStation");
            return (Criteria) this;
        }

        public Criteria andAcceptStationLike(String value) {
            addCriterion("ACCEPT_STATION like", value, "acceptStation");
            return (Criteria) this;
        }

        public Criteria andAcceptStationNotLike(String value) {
            addCriterion("ACCEPT_STATION not like", value, "acceptStation");
            return (Criteria) this;
        }

        public Criteria andAcceptStationIn(List<String> values) {
            addCriterion("ACCEPT_STATION in", values, "acceptStation");
            return (Criteria) this;
        }

        public Criteria andAcceptStationNotIn(List<String> values) {
            addCriterion("ACCEPT_STATION not in", values, "acceptStation");
            return (Criteria) this;
        }

        public Criteria andAcceptStationBetween(String value1, String value2) {
            addCriterion("ACCEPT_STATION between", value1, value2, "acceptStation");
            return (Criteria) this;
        }

        public Criteria andAcceptStationNotBetween(String value1, String value2) {
            addCriterion("ACCEPT_STATION not between", value1, value2, "acceptStation");
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