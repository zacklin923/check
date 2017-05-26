package com.zs.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VersionUpdateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VersionUpdateExample() {
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

        public Criteria andVerNumIsNull() {
            addCriterion("VER_NUM is null");
            return (Criteria) this;
        }

        public Criteria andVerNumIsNotNull() {
            addCriterion("VER_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andVerNumEqualTo(String value) {
            addCriterion("VER_NUM =", value, "verNum");
            return (Criteria) this;
        }

        public Criteria andVerNumNotEqualTo(String value) {
            addCriterion("VER_NUM <>", value, "verNum");
            return (Criteria) this;
        }

        public Criteria andVerNumGreaterThan(String value) {
            addCriterion("VER_NUM >", value, "verNum");
            return (Criteria) this;
        }

        public Criteria andVerNumGreaterThanOrEqualTo(String value) {
            addCriterion("VER_NUM >=", value, "verNum");
            return (Criteria) this;
        }

        public Criteria andVerNumLessThan(String value) {
            addCriterion("VER_NUM <", value, "verNum");
            return (Criteria) this;
        }

        public Criteria andVerNumLessThanOrEqualTo(String value) {
            addCriterion("VER_NUM <=", value, "verNum");
            return (Criteria) this;
        }

        public Criteria andVerNumLike(String value) {
            addCriterion("VER_NUM like", value, "verNum");
            return (Criteria) this;
        }

        public Criteria andVerNumNotLike(String value) {
            addCriterion("VER_NUM not like", value, "verNum");
            return (Criteria) this;
        }

        public Criteria andVerNumIn(List<String> values) {
            addCriterion("VER_NUM in", values, "verNum");
            return (Criteria) this;
        }

        public Criteria andVerNumNotIn(List<String> values) {
            addCriterion("VER_NUM not in", values, "verNum");
            return (Criteria) this;
        }

        public Criteria andVerNumBetween(String value1, String value2) {
            addCriterion("VER_NUM between", value1, value2, "verNum");
            return (Criteria) this;
        }

        public Criteria andVerNumNotBetween(String value1, String value2) {
            addCriterion("VER_NUM not between", value1, value2, "verNum");
            return (Criteria) this;
        }

        public Criteria andVerDescIsNull() {
            addCriterion("VER_DESC is null");
            return (Criteria) this;
        }

        public Criteria andVerDescIsNotNull() {
            addCriterion("VER_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andVerDescEqualTo(String value) {
            addCriterion("VER_DESC =", value, "verDesc");
            return (Criteria) this;
        }

        public Criteria andVerDescNotEqualTo(String value) {
            addCriterion("VER_DESC <>", value, "verDesc");
            return (Criteria) this;
        }

        public Criteria andVerDescGreaterThan(String value) {
            addCriterion("VER_DESC >", value, "verDesc");
            return (Criteria) this;
        }

        public Criteria andVerDescGreaterThanOrEqualTo(String value) {
            addCriterion("VER_DESC >=", value, "verDesc");
            return (Criteria) this;
        }

        public Criteria andVerDescLessThan(String value) {
            addCriterion("VER_DESC <", value, "verDesc");
            return (Criteria) this;
        }

        public Criteria andVerDescLessThanOrEqualTo(String value) {
            addCriterion("VER_DESC <=", value, "verDesc");
            return (Criteria) this;
        }

        public Criteria andVerDescLike(String value) {
            addCriterion("VER_DESC like", value, "verDesc");
            return (Criteria) this;
        }

        public Criteria andVerDescNotLike(String value) {
            addCriterion("VER_DESC not like", value, "verDesc");
            return (Criteria) this;
        }

        public Criteria andVerDescIn(List<String> values) {
            addCriterion("VER_DESC in", values, "verDesc");
            return (Criteria) this;
        }

        public Criteria andVerDescNotIn(List<String> values) {
            addCriterion("VER_DESC not in", values, "verDesc");
            return (Criteria) this;
        }

        public Criteria andVerDescBetween(String value1, String value2) {
            addCriterion("VER_DESC between", value1, value2, "verDesc");
            return (Criteria) this;
        }

        public Criteria andVerDescNotBetween(String value1, String value2) {
            addCriterion("VER_DESC not between", value1, value2, "verDesc");
            return (Criteria) this;
        }

        public Criteria andVerStuNumsIsNull() {
            addCriterion("VER_STU_NUMS is null");
            return (Criteria) this;
        }

        public Criteria andVerStuNumsIsNotNull() {
            addCriterion("VER_STU_NUMS is not null");
            return (Criteria) this;
        }

        public Criteria andVerStuNumsEqualTo(String value) {
            addCriterion("VER_STU_NUMS =", value, "verStuNums");
            return (Criteria) this;
        }

        public Criteria andVerStuNumsNotEqualTo(String value) {
            addCriterion("VER_STU_NUMS <>", value, "verStuNums");
            return (Criteria) this;
        }

        public Criteria andVerStuNumsGreaterThan(String value) {
            addCriterion("VER_STU_NUMS >", value, "verStuNums");
            return (Criteria) this;
        }

        public Criteria andVerStuNumsGreaterThanOrEqualTo(String value) {
            addCriterion("VER_STU_NUMS >=", value, "verStuNums");
            return (Criteria) this;
        }

        public Criteria andVerStuNumsLessThan(String value) {
            addCriterion("VER_STU_NUMS <", value, "verStuNums");
            return (Criteria) this;
        }

        public Criteria andVerStuNumsLessThanOrEqualTo(String value) {
            addCriterion("VER_STU_NUMS <=", value, "verStuNums");
            return (Criteria) this;
        }

        public Criteria andVerStuNumsLike(String value) {
            addCriterion("VER_STU_NUMS like", value, "verStuNums");
            return (Criteria) this;
        }

        public Criteria andVerStuNumsNotLike(String value) {
            addCriterion("VER_STU_NUMS not like", value, "verStuNums");
            return (Criteria) this;
        }

        public Criteria andVerStuNumsIn(List<String> values) {
            addCriterion("VER_STU_NUMS in", values, "verStuNums");
            return (Criteria) this;
        }

        public Criteria andVerStuNumsNotIn(List<String> values) {
            addCriterion("VER_STU_NUMS not in", values, "verStuNums");
            return (Criteria) this;
        }

        public Criteria andVerStuNumsBetween(String value1, String value2) {
            addCriterion("VER_STU_NUMS between", value1, value2, "verStuNums");
            return (Criteria) this;
        }

        public Criteria andVerStuNumsNotBetween(String value1, String value2) {
            addCriterion("VER_STU_NUMS not between", value1, value2, "verStuNums");
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