package com.zs.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportSignExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReportSignExample() {
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

        public Criteria andCtmBarCodeIsNull() {
            addCriterion("CTM_BAR_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeIsNotNull() {
            addCriterion("CTM_BAR_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeEqualTo(String value) {
            addCriterion("CTM_BAR_CODE =", value, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeNotEqualTo(String value) {
            addCriterion("CTM_BAR_CODE <>", value, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeGreaterThan(String value) {
            addCriterion("CTM_BAR_CODE >", value, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CTM_BAR_CODE >=", value, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeLessThan(String value) {
            addCriterion("CTM_BAR_CODE <", value, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeLessThanOrEqualTo(String value) {
            addCriterion("CTM_BAR_CODE <=", value, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeLike(String value) {
            addCriterion("CTM_BAR_CODE like", value, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeNotLike(String value) {
            addCriterion("CTM_BAR_CODE not like", value, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeIn(List<String> values) {
            addCriterion("CTM_BAR_CODE in", values, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeNotIn(List<String> values) {
            addCriterion("CTM_BAR_CODE not in", values, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeBetween(String value1, String value2) {
            addCriterion("CTM_BAR_CODE between", value1, value2, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andCtmBarCodeNotBetween(String value1, String value2) {
            addCriterion("CTM_BAR_CODE not between", value1, value2, "ctmBarCode");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("SEND_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("SEND_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("SEND_TIME =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("SEND_TIME <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("SEND_TIME >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SEND_TIME >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("SEND_TIME <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("SEND_TIME <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("SEND_TIME in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("SEND_TIME not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("SEND_TIME between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("SEND_TIME not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andBeginCityIsNull() {
            addCriterion("BEGIN_CITY is null");
            return (Criteria) this;
        }

        public Criteria andBeginCityIsNotNull() {
            addCriterion("BEGIN_CITY is not null");
            return (Criteria) this;
        }

        public Criteria andBeginCityEqualTo(String value) {
            addCriterion("BEGIN_CITY =", value, "beginCity");
            return (Criteria) this;
        }

        public Criteria andBeginCityNotEqualTo(String value) {
            addCriterion("BEGIN_CITY <>", value, "beginCity");
            return (Criteria) this;
        }

        public Criteria andBeginCityGreaterThan(String value) {
            addCriterion("BEGIN_CITY >", value, "beginCity");
            return (Criteria) this;
        }

        public Criteria andBeginCityGreaterThanOrEqualTo(String value) {
            addCriterion("BEGIN_CITY >=", value, "beginCity");
            return (Criteria) this;
        }

        public Criteria andBeginCityLessThan(String value) {
            addCriterion("BEGIN_CITY <", value, "beginCity");
            return (Criteria) this;
        }

        public Criteria andBeginCityLessThanOrEqualTo(String value) {
            addCriterion("BEGIN_CITY <=", value, "beginCity");
            return (Criteria) this;
        }

        public Criteria andBeginCityLike(String value) {
            addCriterion("BEGIN_CITY like", value, "beginCity");
            return (Criteria) this;
        }

        public Criteria andBeginCityNotLike(String value) {
            addCriterion("BEGIN_CITY not like", value, "beginCity");
            return (Criteria) this;
        }

        public Criteria andBeginCityIn(List<String> values) {
            addCriterion("BEGIN_CITY in", values, "beginCity");
            return (Criteria) this;
        }

        public Criteria andBeginCityNotIn(List<String> values) {
            addCriterion("BEGIN_CITY not in", values, "beginCity");
            return (Criteria) this;
        }

        public Criteria andBeginCityBetween(String value1, String value2) {
            addCriterion("BEGIN_CITY between", value1, value2, "beginCity");
            return (Criteria) this;
        }

        public Criteria andBeginCityNotBetween(String value1, String value2) {
            addCriterion("BEGIN_CITY not between", value1, value2, "beginCity");
            return (Criteria) this;
        }

        public Criteria andCtmNameIsNull() {
            addCriterion("CTM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCtmNameIsNotNull() {
            addCriterion("CTM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCtmNameEqualTo(String value) {
            addCriterion("CTM_NAME =", value, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameNotEqualTo(String value) {
            addCriterion("CTM_NAME <>", value, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameGreaterThan(String value) {
            addCriterion("CTM_NAME >", value, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameGreaterThanOrEqualTo(String value) {
            addCriterion("CTM_NAME >=", value, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameLessThan(String value) {
            addCriterion("CTM_NAME <", value, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameLessThanOrEqualTo(String value) {
            addCriterion("CTM_NAME <=", value, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameLike(String value) {
            addCriterion("CTM_NAME like", value, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameNotLike(String value) {
            addCriterion("CTM_NAME not like", value, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameIn(List<String> values) {
            addCriterion("CTM_NAME in", values, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameNotIn(List<String> values) {
            addCriterion("CTM_NAME not in", values, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameBetween(String value1, String value2) {
            addCriterion("CTM_NAME between", value1, value2, "ctmName");
            return (Criteria) this;
        }

        public Criteria andCtmNameNotBetween(String value1, String value2) {
            addCriterion("CTM_NAME not between", value1, value2, "ctmName");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("PROVINCE =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("PROVINCE <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("PROVINCE >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("PROVINCE <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("PROVINCE like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("PROVINCE not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("PROVINCE in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("PROVINCE not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("PROVINCE between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("PROVINCE not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCostHourIsNull() {
            addCriterion("COST_HOUR is null");
            return (Criteria) this;
        }

        public Criteria andCostHourIsNotNull() {
            addCriterion("COST_HOUR is not null");
            return (Criteria) this;
        }

        public Criteria andCostHourEqualTo(BigDecimal value) {
            addCriterion("COST_HOUR =", value, "costHour");
            return (Criteria) this;
        }

        public Criteria andCostHourNotEqualTo(BigDecimal value) {
            addCriterion("COST_HOUR <>", value, "costHour");
            return (Criteria) this;
        }

        public Criteria andCostHourGreaterThan(BigDecimal value) {
            addCriterion("COST_HOUR >", value, "costHour");
            return (Criteria) this;
        }

        public Criteria andCostHourGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COST_HOUR >=", value, "costHour");
            return (Criteria) this;
        }

        public Criteria andCostHourLessThan(BigDecimal value) {
            addCriterion("COST_HOUR <", value, "costHour");
            return (Criteria) this;
        }

        public Criteria andCostHourLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COST_HOUR <=", value, "costHour");
            return (Criteria) this;
        }

        public Criteria andCostHourIn(List<BigDecimal> values) {
            addCriterion("COST_HOUR in", values, "costHour");
            return (Criteria) this;
        }

        public Criteria andCostHourNotIn(List<BigDecimal> values) {
            addCriterion("COST_HOUR not in", values, "costHour");
            return (Criteria) this;
        }

        public Criteria andCostHourBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COST_HOUR between", value1, value2, "costHour");
            return (Criteria) this;
        }

        public Criteria andCostHourNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COST_HOUR not between", value1, value2, "costHour");
            return (Criteria) this;
        }

        public Criteria andTotalSendIsNull() {
            addCriterion("TOTAL_SEND is null");
            return (Criteria) this;
        }

        public Criteria andTotalSendIsNotNull() {
            addCriterion("TOTAL_SEND is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSendEqualTo(BigDecimal value) {
            addCriterion("TOTAL_SEND =", value, "totalSend");
            return (Criteria) this;
        }

        public Criteria andTotalSendNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_SEND <>", value, "totalSend");
            return (Criteria) this;
        }

        public Criteria andTotalSendGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_SEND >", value, "totalSend");
            return (Criteria) this;
        }

        public Criteria andTotalSendGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_SEND >=", value, "totalSend");
            return (Criteria) this;
        }

        public Criteria andTotalSendLessThan(BigDecimal value) {
            addCriterion("TOTAL_SEND <", value, "totalSend");
            return (Criteria) this;
        }

        public Criteria andTotalSendLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_SEND <=", value, "totalSend");
            return (Criteria) this;
        }

        public Criteria andTotalSendIn(List<BigDecimal> values) {
            addCriterion("TOTAL_SEND in", values, "totalSend");
            return (Criteria) this;
        }

        public Criteria andTotalSendNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_SEND not in", values, "totalSend");
            return (Criteria) this;
        }

        public Criteria andTotalSendBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_SEND between", value1, value2, "totalSend");
            return (Criteria) this;
        }

        public Criteria andTotalSendNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_SEND not between", value1, value2, "totalSend");
            return (Criteria) this;
        }

        public Criteria andTotalSuccIsNull() {
            addCriterion("TOTAL_SUCC is null");
            return (Criteria) this;
        }

        public Criteria andTotalSuccIsNotNull() {
            addCriterion("TOTAL_SUCC is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSuccEqualTo(BigDecimal value) {
            addCriterion("TOTAL_SUCC =", value, "totalSucc");
            return (Criteria) this;
        }

        public Criteria andTotalSuccNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_SUCC <>", value, "totalSucc");
            return (Criteria) this;
        }

        public Criteria andTotalSuccGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_SUCC >", value, "totalSucc");
            return (Criteria) this;
        }

        public Criteria andTotalSuccGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_SUCC >=", value, "totalSucc");
            return (Criteria) this;
        }

        public Criteria andTotalSuccLessThan(BigDecimal value) {
            addCriterion("TOTAL_SUCC <", value, "totalSucc");
            return (Criteria) this;
        }

        public Criteria andTotalSuccLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_SUCC <=", value, "totalSucc");
            return (Criteria) this;
        }

        public Criteria andTotalSuccIn(List<BigDecimal> values) {
            addCriterion("TOTAL_SUCC in", values, "totalSucc");
            return (Criteria) this;
        }

        public Criteria andTotalSuccNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_SUCC not in", values, "totalSucc");
            return (Criteria) this;
        }

        public Criteria andTotalSuccBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_SUCC between", value1, value2, "totalSucc");
            return (Criteria) this;
        }

        public Criteria andTotalSuccNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_SUCC not between", value1, value2, "totalSucc");
            return (Criteria) this;
        }

        public Criteria andTotalSuccTimeoutIsNull() {
            addCriterion("TOTAL_SUCC_TIMEOUT is null");
            return (Criteria) this;
        }

        public Criteria andTotalSuccTimeoutIsNotNull() {
            addCriterion("TOTAL_SUCC_TIMEOUT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSuccTimeoutEqualTo(BigDecimal value) {
            addCriterion("TOTAL_SUCC_TIMEOUT =", value, "totalSuccTimeout");
            return (Criteria) this;
        }

        public Criteria andTotalSuccTimeoutNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_SUCC_TIMEOUT <>", value, "totalSuccTimeout");
            return (Criteria) this;
        }

        public Criteria andTotalSuccTimeoutGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_SUCC_TIMEOUT >", value, "totalSuccTimeout");
            return (Criteria) this;
        }

        public Criteria andTotalSuccTimeoutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_SUCC_TIMEOUT >=", value, "totalSuccTimeout");
            return (Criteria) this;
        }

        public Criteria andTotalSuccTimeoutLessThan(BigDecimal value) {
            addCriterion("TOTAL_SUCC_TIMEOUT <", value, "totalSuccTimeout");
            return (Criteria) this;
        }

        public Criteria andTotalSuccTimeoutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_SUCC_TIMEOUT <=", value, "totalSuccTimeout");
            return (Criteria) this;
        }

        public Criteria andTotalSuccTimeoutIn(List<BigDecimal> values) {
            addCriterion("TOTAL_SUCC_TIMEOUT in", values, "totalSuccTimeout");
            return (Criteria) this;
        }

        public Criteria andTotalSuccTimeoutNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_SUCC_TIMEOUT not in", values, "totalSuccTimeout");
            return (Criteria) this;
        }

        public Criteria andTotalSuccTimeoutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_SUCC_TIMEOUT between", value1, value2, "totalSuccTimeout");
            return (Criteria) this;
        }

        public Criteria andTotalSuccTimeoutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_SUCC_TIMEOUT not between", value1, value2, "totalSuccTimeout");
            return (Criteria) this;
        }

        public Criteria andWaitCourierNumberIsNull() {
            addCriterion("WAIT_COURIER_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andWaitCourierNumberIsNotNull() {
            addCriterion("WAIT_COURIER_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andWaitCourierNumberEqualTo(String value) {
            addCriterion("WAIT_COURIER_NUMBER =", value, "waitCourierNumber");
            return (Criteria) this;
        }

        public Criteria andWaitCourierNumberNotEqualTo(String value) {
            addCriterion("WAIT_COURIER_NUMBER <>", value, "waitCourierNumber");
            return (Criteria) this;
        }

        public Criteria andWaitCourierNumberGreaterThan(String value) {
            addCriterion("WAIT_COURIER_NUMBER >", value, "waitCourierNumber");
            return (Criteria) this;
        }

        public Criteria andWaitCourierNumberGreaterThanOrEqualTo(String value) {
            addCriterion("WAIT_COURIER_NUMBER >=", value, "waitCourierNumber");
            return (Criteria) this;
        }

        public Criteria andWaitCourierNumberLessThan(String value) {
            addCriterion("WAIT_COURIER_NUMBER <", value, "waitCourierNumber");
            return (Criteria) this;
        }

        public Criteria andWaitCourierNumberLessThanOrEqualTo(String value) {
            addCriterion("WAIT_COURIER_NUMBER <=", value, "waitCourierNumber");
            return (Criteria) this;
        }

        public Criteria andWaitCourierNumberLike(String value) {
            addCriterion("WAIT_COURIER_NUMBER like", value, "waitCourierNumber");
            return (Criteria) this;
        }

        public Criteria andWaitCourierNumberNotLike(String value) {
            addCriterion("WAIT_COURIER_NUMBER not like", value, "waitCourierNumber");
            return (Criteria) this;
        }

        public Criteria andWaitCourierNumberIn(List<String> values) {
            addCriterion("WAIT_COURIER_NUMBER in", values, "waitCourierNumber");
            return (Criteria) this;
        }

        public Criteria andWaitCourierNumberNotIn(List<String> values) {
            addCriterion("WAIT_COURIER_NUMBER not in", values, "waitCourierNumber");
            return (Criteria) this;
        }

        public Criteria andWaitCourierNumberBetween(String value1, String value2) {
            addCriterion("WAIT_COURIER_NUMBER between", value1, value2, "waitCourierNumber");
            return (Criteria) this;
        }

        public Criteria andWaitCourierNumberNotBetween(String value1, String value2) {
            addCriterion("WAIT_COURIER_NUMBER not between", value1, value2, "waitCourierNumber");
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