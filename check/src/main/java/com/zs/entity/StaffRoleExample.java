package com.zs.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StaffRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StaffRoleExample() {
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

        public Criteria andStrIdIsNull() {
            addCriterion("STR_ID is null");
            return (Criteria) this;
        }

        public Criteria andStrIdIsNotNull() {
            addCriterion("STR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStrIdEqualTo(BigDecimal value) {
            addCriterion("STR_ID =", value, "strId");
            return (Criteria) this;
        }

        public Criteria andStrIdNotEqualTo(BigDecimal value) {
            addCriterion("STR_ID <>", value, "strId");
            return (Criteria) this;
        }

        public Criteria andStrIdGreaterThan(BigDecimal value) {
            addCriterion("STR_ID >", value, "strId");
            return (Criteria) this;
        }

        public Criteria andStrIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STR_ID >=", value, "strId");
            return (Criteria) this;
        }

        public Criteria andStrIdLessThan(BigDecimal value) {
            addCriterion("STR_ID <", value, "strId");
            return (Criteria) this;
        }

        public Criteria andStrIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STR_ID <=", value, "strId");
            return (Criteria) this;
        }

        public Criteria andStrIdIn(List<BigDecimal> values) {
            addCriterion("STR_ID in", values, "strId");
            return (Criteria) this;
        }

        public Criteria andStrIdNotIn(List<BigDecimal> values) {
            addCriterion("STR_ID not in", values, "strId");
            return (Criteria) this;
        }

        public Criteria andStrIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STR_ID between", value1, value2, "strId");
            return (Criteria) this;
        }

        public Criteria andStrIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STR_ID not between", value1, value2, "strId");
            return (Criteria) this;
        }

        public Criteria andStrNameIsNull() {
            addCriterion("STR_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStrNameIsNotNull() {
            addCriterion("STR_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStrNameEqualTo(String value) {
            addCriterion("STR_NAME =", value, "strName");
            return (Criteria) this;
        }

        public Criteria andStrNameNotEqualTo(String value) {
            addCriterion("STR_NAME <>", value, "strName");
            return (Criteria) this;
        }

        public Criteria andStrNameGreaterThan(String value) {
            addCriterion("STR_NAME >", value, "strName");
            return (Criteria) this;
        }

        public Criteria andStrNameGreaterThanOrEqualTo(String value) {
            addCriterion("STR_NAME >=", value, "strName");
            return (Criteria) this;
        }

        public Criteria andStrNameLessThan(String value) {
            addCriterion("STR_NAME <", value, "strName");
            return (Criteria) this;
        }

        public Criteria andStrNameLessThanOrEqualTo(String value) {
            addCriterion("STR_NAME <=", value, "strName");
            return (Criteria) this;
        }

        public Criteria andStrNameLike(String value) {
            addCriterion("STR_NAME like", value, "strName");
            return (Criteria) this;
        }

        public Criteria andStrNameNotLike(String value) {
            addCriterion("STR_NAME not like", value, "strName");
            return (Criteria) this;
        }

        public Criteria andStrNameIn(List<String> values) {
            addCriterion("STR_NAME in", values, "strName");
            return (Criteria) this;
        }

        public Criteria andStrNameNotIn(List<String> values) {
            addCriterion("STR_NAME not in", values, "strName");
            return (Criteria) this;
        }

        public Criteria andStrNameBetween(String value1, String value2) {
            addCriterion("STR_NAME between", value1, value2, "strName");
            return (Criteria) this;
        }

        public Criteria andStrNameNotBetween(String value1, String value2) {
            addCriterion("STR_NAME not between", value1, value2, "strName");
            return (Criteria) this;
        }

        public Criteria andStrDescIsNull() {
            addCriterion("STR_DESC is null");
            return (Criteria) this;
        }

        public Criteria andStrDescIsNotNull() {
            addCriterion("STR_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andStrDescEqualTo(String value) {
            addCriterion("STR_DESC =", value, "strDesc");
            return (Criteria) this;
        }

        public Criteria andStrDescNotEqualTo(String value) {
            addCriterion("STR_DESC <>", value, "strDesc");
            return (Criteria) this;
        }

        public Criteria andStrDescGreaterThan(String value) {
            addCriterion("STR_DESC >", value, "strDesc");
            return (Criteria) this;
        }

        public Criteria andStrDescGreaterThanOrEqualTo(String value) {
            addCriterion("STR_DESC >=", value, "strDesc");
            return (Criteria) this;
        }

        public Criteria andStrDescLessThan(String value) {
            addCriterion("STR_DESC <", value, "strDesc");
            return (Criteria) this;
        }

        public Criteria andStrDescLessThanOrEqualTo(String value) {
            addCriterion("STR_DESC <=", value, "strDesc");
            return (Criteria) this;
        }

        public Criteria andStrDescLike(String value) {
            addCriterion("STR_DESC like", value, "strDesc");
            return (Criteria) this;
        }

        public Criteria andStrDescNotLike(String value) {
            addCriterion("STR_DESC not like", value, "strDesc");
            return (Criteria) this;
        }

        public Criteria andStrDescIn(List<String> values) {
            addCriterion("STR_DESC in", values, "strDesc");
            return (Criteria) this;
        }

        public Criteria andStrDescNotIn(List<String> values) {
            addCriterion("STR_DESC not in", values, "strDesc");
            return (Criteria) this;
        }

        public Criteria andStrDescBetween(String value1, String value2) {
            addCriterion("STR_DESC between", value1, value2, "strDesc");
            return (Criteria) this;
        }

        public Criteria andStrDescNotBetween(String value1, String value2) {
            addCriterion("STR_DESC not between", value1, value2, "strDesc");
            return (Criteria) this;
        }

        public Criteria andPowersIsNull() {
            addCriterion("POWERS is null");
            return (Criteria) this;
        }

        public Criteria andPowersIsNotNull() {
            addCriterion("POWERS is not null");
            return (Criteria) this;
        }

        public Criteria andPowersEqualTo(String value) {
            addCriterion("POWERS =", value, "powers");
            return (Criteria) this;
        }

        public Criteria andPowersNotEqualTo(String value) {
            addCriterion("POWERS <>", value, "powers");
            return (Criteria) this;
        }

        public Criteria andPowersGreaterThan(String value) {
            addCriterion("POWERS >", value, "powers");
            return (Criteria) this;
        }

        public Criteria andPowersGreaterThanOrEqualTo(String value) {
            addCriterion("POWERS >=", value, "powers");
            return (Criteria) this;
        }

        public Criteria andPowersLessThan(String value) {
            addCriterion("POWERS <", value, "powers");
            return (Criteria) this;
        }

        public Criteria andPowersLessThanOrEqualTo(String value) {
            addCriterion("POWERS <=", value, "powers");
            return (Criteria) this;
        }

        public Criteria andPowersLike(String value) {
            addCriterion("POWERS like", value, "powers");
            return (Criteria) this;
        }

        public Criteria andPowersNotLike(String value) {
            addCriterion("POWERS not like", value, "powers");
            return (Criteria) this;
        }

        public Criteria andPowersIn(List<String> values) {
            addCriterion("POWERS in", values, "powers");
            return (Criteria) this;
        }

        public Criteria andPowersNotIn(List<String> values) {
            addCriterion("POWERS not in", values, "powers");
            return (Criteria) this;
        }

        public Criteria andPowersBetween(String value1, String value2) {
            addCriterion("POWERS between", value1, value2, "powers");
            return (Criteria) this;
        }

        public Criteria andPowersNotBetween(String value1, String value2) {
            addCriterion("POWERS not between", value1, value2, "powers");
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