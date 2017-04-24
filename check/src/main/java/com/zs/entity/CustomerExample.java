package com.zs.entity;

import java.util.ArrayList;
import java.util.Date;
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

        public Criteria andBarCodeIsNull() {
            addCriterion("BAR_CODE is null");
            return (Criteria) this;
        }

        public Criteria andBarCodeIsNotNull() {
            addCriterion("BAR_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andBarCodeEqualTo(String value) {
            addCriterion("BAR_CODE =", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotEqualTo(String value) {
            addCriterion("BAR_CODE <>", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeGreaterThan(String value) {
            addCriterion("BAR_CODE >", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BAR_CODE >=", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLessThan(String value) {
            addCriterion("BAR_CODE <", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLessThanOrEqualTo(String value) {
            addCriterion("BAR_CODE <=", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLike(String value) {
            addCriterion("BAR_CODE like", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotLike(String value) {
            addCriterion("BAR_CODE not like", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeIn(List<String> values) {
            addCriterion("BAR_CODE in", values, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotIn(List<String> values) {
            addCriterion("BAR_CODE not in", values, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeBetween(String value1, String value2) {
            addCriterion("BAR_CODE between", value1, value2, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotBetween(String value1, String value2) {
            addCriterion("BAR_CODE not between", value1, value2, "barCode");
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

        public Criteria andBarCodeParentIsNull() {
            addCriterion("BAR_CODE_PARENT is null");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentIsNotNull() {
            addCriterion("BAR_CODE_PARENT is not null");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentEqualTo(String value) {
            addCriterion("BAR_CODE_PARENT =", value, "barCodeParent");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentNotEqualTo(String value) {
            addCriterion("BAR_CODE_PARENT <>", value, "barCodeParent");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentGreaterThan(String value) {
            addCriterion("BAR_CODE_PARENT >", value, "barCodeParent");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentGreaterThanOrEqualTo(String value) {
            addCriterion("BAR_CODE_PARENT >=", value, "barCodeParent");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentLessThan(String value) {
            addCriterion("BAR_CODE_PARENT <", value, "barCodeParent");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentLessThanOrEqualTo(String value) {
            addCriterion("BAR_CODE_PARENT <=", value, "barCodeParent");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentLike(String value) {
            addCriterion("BAR_CODE_PARENT like", value, "barCodeParent");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentNotLike(String value) {
            addCriterion("BAR_CODE_PARENT not like", value, "barCodeParent");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentIn(List<String> values) {
            addCriterion("BAR_CODE_PARENT in", values, "barCodeParent");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentNotIn(List<String> values) {
            addCriterion("BAR_CODE_PARENT not in", values, "barCodeParent");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentBetween(String value1, String value2) {
            addCriterion("BAR_CODE_PARENT between", value1, value2, "barCodeParent");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentNotBetween(String value1, String value2) {
            addCriterion("BAR_CODE_PARENT not between", value1, value2, "barCodeParent");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentNameIsNull() {
            addCriterion("BAR_CODE_PARENT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentNameIsNotNull() {
            addCriterion("BAR_CODE_PARENT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentNameEqualTo(String value) {
            addCriterion("BAR_CODE_PARENT_NAME =", value, "barCodeParentName");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentNameNotEqualTo(String value) {
            addCriterion("BAR_CODE_PARENT_NAME <>", value, "barCodeParentName");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentNameGreaterThan(String value) {
            addCriterion("BAR_CODE_PARENT_NAME >", value, "barCodeParentName");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentNameGreaterThanOrEqualTo(String value) {
            addCriterion("BAR_CODE_PARENT_NAME >=", value, "barCodeParentName");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentNameLessThan(String value) {
            addCriterion("BAR_CODE_PARENT_NAME <", value, "barCodeParentName");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentNameLessThanOrEqualTo(String value) {
            addCriterion("BAR_CODE_PARENT_NAME <=", value, "barCodeParentName");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentNameLike(String value) {
            addCriterion("BAR_CODE_PARENT_NAME like", value, "barCodeParentName");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentNameNotLike(String value) {
            addCriterion("BAR_CODE_PARENT_NAME not like", value, "barCodeParentName");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentNameIn(List<String> values) {
            addCriterion("BAR_CODE_PARENT_NAME in", values, "barCodeParentName");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentNameNotIn(List<String> values) {
            addCriterion("BAR_CODE_PARENT_NAME not in", values, "barCodeParentName");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentNameBetween(String value1, String value2) {
            addCriterion("BAR_CODE_PARENT_NAME between", value1, value2, "barCodeParentName");
            return (Criteria) this;
        }

        public Criteria andBarCodeParentNameNotBetween(String value1, String value2) {
            addCriterion("BAR_CODE_PARENT_NAME not between", value1, value2, "barCodeParentName");
            return (Criteria) this;
        }

        public Criteria andScliceAreaIsNull() {
            addCriterion("SCLICE_AREA is null");
            return (Criteria) this;
        }

        public Criteria andScliceAreaIsNotNull() {
            addCriterion("SCLICE_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andScliceAreaEqualTo(String value) {
            addCriterion("SCLICE_AREA =", value, "scliceArea");
            return (Criteria) this;
        }

        public Criteria andScliceAreaNotEqualTo(String value) {
            addCriterion("SCLICE_AREA <>", value, "scliceArea");
            return (Criteria) this;
        }

        public Criteria andScliceAreaGreaterThan(String value) {
            addCriterion("SCLICE_AREA >", value, "scliceArea");
            return (Criteria) this;
        }

        public Criteria andScliceAreaGreaterThanOrEqualTo(String value) {
            addCriterion("SCLICE_AREA >=", value, "scliceArea");
            return (Criteria) this;
        }

        public Criteria andScliceAreaLessThan(String value) {
            addCriterion("SCLICE_AREA <", value, "scliceArea");
            return (Criteria) this;
        }

        public Criteria andScliceAreaLessThanOrEqualTo(String value) {
            addCriterion("SCLICE_AREA <=", value, "scliceArea");
            return (Criteria) this;
        }

        public Criteria andScliceAreaLike(String value) {
            addCriterion("SCLICE_AREA like", value, "scliceArea");
            return (Criteria) this;
        }

        public Criteria andScliceAreaNotLike(String value) {
            addCriterion("SCLICE_AREA not like", value, "scliceArea");
            return (Criteria) this;
        }

        public Criteria andScliceAreaIn(List<String> values) {
            addCriterion("SCLICE_AREA in", values, "scliceArea");
            return (Criteria) this;
        }

        public Criteria andScliceAreaNotIn(List<String> values) {
            addCriterion("SCLICE_AREA not in", values, "scliceArea");
            return (Criteria) this;
        }

        public Criteria andScliceAreaBetween(String value1, String value2) {
            addCriterion("SCLICE_AREA between", value1, value2, "scliceArea");
            return (Criteria) this;
        }

        public Criteria andScliceAreaNotBetween(String value1, String value2) {
            addCriterion("SCLICE_AREA not between", value1, value2, "scliceArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaIsNull() {
            addCriterion("LARGE_AREA is null");
            return (Criteria) this;
        }

        public Criteria andLargeAreaIsNotNull() {
            addCriterion("LARGE_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andLargeAreaEqualTo(String value) {
            addCriterion("LARGE_AREA =", value, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaNotEqualTo(String value) {
            addCriterion("LARGE_AREA <>", value, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaGreaterThan(String value) {
            addCriterion("LARGE_AREA >", value, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaGreaterThanOrEqualTo(String value) {
            addCriterion("LARGE_AREA >=", value, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaLessThan(String value) {
            addCriterion("LARGE_AREA <", value, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaLessThanOrEqualTo(String value) {
            addCriterion("LARGE_AREA <=", value, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaLike(String value) {
            addCriterion("LARGE_AREA like", value, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaNotLike(String value) {
            addCriterion("LARGE_AREA not like", value, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaIn(List<String> values) {
            addCriterion("LARGE_AREA in", values, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaNotIn(List<String> values) {
            addCriterion("LARGE_AREA not in", values, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaBetween(String value1, String value2) {
            addCriterion("LARGE_AREA between", value1, value2, "largeArea");
            return (Criteria) this;
        }

        public Criteria andLargeAreaNotBetween(String value1, String value2) {
            addCriterion("LARGE_AREA not between", value1, value2, "largeArea");
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