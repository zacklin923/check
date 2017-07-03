package com.zs.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KdniaoReturnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KdniaoReturnExample() {
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

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
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

        public Criteria andIsdrawIsNull() {
            addCriterion("ISDRAW is null");
            return (Criteria) this;
        }

        public Criteria andIsdrawIsNotNull() {
            addCriterion("ISDRAW is not null");
            return (Criteria) this;
        }

        public Criteria andIsdrawEqualTo(String value) {
            addCriterion("ISDRAW =", value, "isdraw");
            return (Criteria) this;
        }

        public Criteria andIsdrawNotEqualTo(String value) {
            addCriterion("ISDRAW <>", value, "isdraw");
            return (Criteria) this;
        }

        public Criteria andIsdrawGreaterThan(String value) {
            addCriterion("ISDRAW >", value, "isdraw");
            return (Criteria) this;
        }

        public Criteria andIsdrawGreaterThanOrEqualTo(String value) {
            addCriterion("ISDRAW >=", value, "isdraw");
            return (Criteria) this;
        }

        public Criteria andIsdrawLessThan(String value) {
            addCriterion("ISDRAW <", value, "isdraw");
            return (Criteria) this;
        }

        public Criteria andIsdrawLessThanOrEqualTo(String value) {
            addCriterion("ISDRAW <=", value, "isdraw");
            return (Criteria) this;
        }

        public Criteria andIsdrawLike(String value) {
            addCriterion("ISDRAW like", value, "isdraw");
            return (Criteria) this;
        }

        public Criteria andIsdrawNotLike(String value) {
            addCriterion("ISDRAW not like", value, "isdraw");
            return (Criteria) this;
        }

        public Criteria andIsdrawIn(List<String> values) {
            addCriterion("ISDRAW in", values, "isdraw");
            return (Criteria) this;
        }

        public Criteria andIsdrawNotIn(List<String> values) {
            addCriterion("ISDRAW not in", values, "isdraw");
            return (Criteria) this;
        }

        public Criteria andIsdrawBetween(String value1, String value2) {
            addCriterion("ISDRAW between", value1, value2, "isdraw");
            return (Criteria) this;
        }

        public Criteria andIsdrawNotBetween(String value1, String value2) {
            addCriterion("ISDRAW not between", value1, value2, "isdraw");
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