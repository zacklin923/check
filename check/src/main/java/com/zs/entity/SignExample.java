package com.zs.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SignExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SignExample() {
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

        public Criteria andCourierNumberIsNull() {
            addCriterion("COURIER_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andCourierNumberIsNotNull() {
            addCriterion("COURIER_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andCourierNumberEqualTo(BigDecimal value) {
            addCriterion("COURIER_NUMBER =", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberNotEqualTo(BigDecimal value) {
            addCriterion("COURIER_NUMBER <>", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberGreaterThan(BigDecimal value) {
            addCriterion("COURIER_NUMBER >", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COURIER_NUMBER >=", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberLessThan(BigDecimal value) {
            addCriterion("COURIER_NUMBER <", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COURIER_NUMBER <=", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberIn(List<BigDecimal> values) {
            addCriterion("COURIER_NUMBER in", values, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberNotIn(List<BigDecimal> values) {
            addCriterion("COURIER_NUMBER not in", values, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COURIER_NUMBER between", value1, value2, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COURIER_NUMBER not between", value1, value2, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andDeliveryStateIsNull() {
            addCriterion("DELIVERY_STATE is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryStateIsNotNull() {
            addCriterion("DELIVERY_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryStateEqualTo(String value) {
            addCriterion("DELIVERY_STATE =", value, "deliveryState");
            return (Criteria) this;
        }

        public Criteria andDeliveryStateNotEqualTo(String value) {
            addCriterion("DELIVERY_STATE <>", value, "deliveryState");
            return (Criteria) this;
        }

        public Criteria andDeliveryStateGreaterThan(String value) {
            addCriterion("DELIVERY_STATE >", value, "deliveryState");
            return (Criteria) this;
        }

        public Criteria andDeliveryStateGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVERY_STATE >=", value, "deliveryState");
            return (Criteria) this;
        }

        public Criteria andDeliveryStateLessThan(String value) {
            addCriterion("DELIVERY_STATE <", value, "deliveryState");
            return (Criteria) this;
        }

        public Criteria andDeliveryStateLessThanOrEqualTo(String value) {
            addCriterion("DELIVERY_STATE <=", value, "deliveryState");
            return (Criteria) this;
        }

        public Criteria andDeliveryStateLike(String value) {
            addCriterion("DELIVERY_STATE like", value, "deliveryState");
            return (Criteria) this;
        }

        public Criteria andDeliveryStateNotLike(String value) {
            addCriterion("DELIVERY_STATE not like", value, "deliveryState");
            return (Criteria) this;
        }

        public Criteria andDeliveryStateIn(List<String> values) {
            addCriterion("DELIVERY_STATE in", values, "deliveryState");
            return (Criteria) this;
        }

        public Criteria andDeliveryStateNotIn(List<String> values) {
            addCriterion("DELIVERY_STATE not in", values, "deliveryState");
            return (Criteria) this;
        }

        public Criteria andDeliveryStateBetween(String value1, String value2) {
            addCriterion("DELIVERY_STATE between", value1, value2, "deliveryState");
            return (Criteria) this;
        }

        public Criteria andDeliveryStateNotBetween(String value1, String value2) {
            addCriterion("DELIVERY_STATE not between", value1, value2, "deliveryState");
            return (Criteria) this;
        }

        public Criteria andSignatoryIsNull() {
            addCriterion("SIGNATORY is null");
            return (Criteria) this;
        }

        public Criteria andSignatoryIsNotNull() {
            addCriterion("SIGNATORY is not null");
            return (Criteria) this;
        }

        public Criteria andSignatoryEqualTo(String value) {
            addCriterion("SIGNATORY =", value, "signatory");
            return (Criteria) this;
        }

        public Criteria andSignatoryNotEqualTo(String value) {
            addCriterion("SIGNATORY <>", value, "signatory");
            return (Criteria) this;
        }

        public Criteria andSignatoryGreaterThan(String value) {
            addCriterion("SIGNATORY >", value, "signatory");
            return (Criteria) this;
        }

        public Criteria andSignatoryGreaterThanOrEqualTo(String value) {
            addCriterion("SIGNATORY >=", value, "signatory");
            return (Criteria) this;
        }

        public Criteria andSignatoryLessThan(String value) {
            addCriterion("SIGNATORY <", value, "signatory");
            return (Criteria) this;
        }

        public Criteria andSignatoryLessThanOrEqualTo(String value) {
            addCriterion("SIGNATORY <=", value, "signatory");
            return (Criteria) this;
        }

        public Criteria andSignatoryLike(String value) {
            addCriterion("SIGNATORY like", value, "signatory");
            return (Criteria) this;
        }

        public Criteria andSignatoryNotLike(String value) {
            addCriterion("SIGNATORY not like", value, "signatory");
            return (Criteria) this;
        }

        public Criteria andSignatoryIn(List<String> values) {
            addCriterion("SIGNATORY in", values, "signatory");
            return (Criteria) this;
        }

        public Criteria andSignatoryNotIn(List<String> values) {
            addCriterion("SIGNATORY not in", values, "signatory");
            return (Criteria) this;
        }

        public Criteria andSignatoryBetween(String value1, String value2) {
            addCriterion("SIGNATORY between", value1, value2, "signatory");
            return (Criteria) this;
        }

        public Criteria andSignatoryNotBetween(String value1, String value2) {
            addCriterion("SIGNATORY not between", value1, value2, "signatory");
            return (Criteria) this;
        }

        public Criteria andSignTimeIsNull() {
            addCriterion("SIGN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSignTimeIsNotNull() {
            addCriterion("SIGN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSignTimeEqualTo(Date value) {
            addCriterion("SIGN_TIME =", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeNotEqualTo(Date value) {
            addCriterion("SIGN_TIME <>", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeGreaterThan(Date value) {
            addCriterion("SIGN_TIME >", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SIGN_TIME >=", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeLessThan(Date value) {
            addCriterion("SIGN_TIME <", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeLessThanOrEqualTo(Date value) {
            addCriterion("SIGN_TIME <=", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeIn(List<Date> values) {
            addCriterion("SIGN_TIME in", values, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeNotIn(List<Date> values) {
            addCriterion("SIGN_TIME not in", values, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeBetween(Date value1, Date value2) {
            addCriterion("SIGN_TIME between", value1, value2, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeNotBetween(Date value1, Date value2) {
            addCriterion("SIGN_TIME not between", value1, value2, "signTime");
            return (Criteria) this;
        }

        public Criteria andAbnormalCauseIsNull() {
            addCriterion("ABNORMAL_CAUSE is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalCauseIsNotNull() {
            addCriterion("ABNORMAL_CAUSE is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalCauseEqualTo(String value) {
            addCriterion("ABNORMAL_CAUSE =", value, "abnormalCause");
            return (Criteria) this;
        }

        public Criteria andAbnormalCauseNotEqualTo(String value) {
            addCriterion("ABNORMAL_CAUSE <>", value, "abnormalCause");
            return (Criteria) this;
        }

        public Criteria andAbnormalCauseGreaterThan(String value) {
            addCriterion("ABNORMAL_CAUSE >", value, "abnormalCause");
            return (Criteria) this;
        }

        public Criteria andAbnormalCauseGreaterThanOrEqualTo(String value) {
            addCriterion("ABNORMAL_CAUSE >=", value, "abnormalCause");
            return (Criteria) this;
        }

        public Criteria andAbnormalCauseLessThan(String value) {
            addCriterion("ABNORMAL_CAUSE <", value, "abnormalCause");
            return (Criteria) this;
        }

        public Criteria andAbnormalCauseLessThanOrEqualTo(String value) {
            addCriterion("ABNORMAL_CAUSE <=", value, "abnormalCause");
            return (Criteria) this;
        }

        public Criteria andAbnormalCauseLike(String value) {
            addCriterion("ABNORMAL_CAUSE like", value, "abnormalCause");
            return (Criteria) this;
        }

        public Criteria andAbnormalCauseNotLike(String value) {
            addCriterion("ABNORMAL_CAUSE not like", value, "abnormalCause");
            return (Criteria) this;
        }

        public Criteria andAbnormalCauseIn(List<String> values) {
            addCriterion("ABNORMAL_CAUSE in", values, "abnormalCause");
            return (Criteria) this;
        }

        public Criteria andAbnormalCauseNotIn(List<String> values) {
            addCriterion("ABNORMAL_CAUSE not in", values, "abnormalCause");
            return (Criteria) this;
        }

        public Criteria andAbnormalCauseBetween(String value1, String value2) {
            addCriterion("ABNORMAL_CAUSE between", value1, value2, "abnormalCause");
            return (Criteria) this;
        }

        public Criteria andAbnormalCauseNotBetween(String value1, String value2) {
            addCriterion("ABNORMAL_CAUSE not between", value1, value2, "abnormalCause");
            return (Criteria) this;
        }

        public Criteria andGoodsCostIsNull() {
            addCriterion("GOODS_COST is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCostIsNotNull() {
            addCriterion("GOODS_COST is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCostEqualTo(BigDecimal value) {
            addCriterion("GOODS_COST =", value, "goodsCost");
            return (Criteria) this;
        }

        public Criteria andGoodsCostNotEqualTo(BigDecimal value) {
            addCriterion("GOODS_COST <>", value, "goodsCost");
            return (Criteria) this;
        }

        public Criteria andGoodsCostGreaterThan(BigDecimal value) {
            addCriterion("GOODS_COST >", value, "goodsCost");
            return (Criteria) this;
        }

        public Criteria andGoodsCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GOODS_COST >=", value, "goodsCost");
            return (Criteria) this;
        }

        public Criteria andGoodsCostLessThan(BigDecimal value) {
            addCriterion("GOODS_COST <", value, "goodsCost");
            return (Criteria) this;
        }

        public Criteria andGoodsCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GOODS_COST <=", value, "goodsCost");
            return (Criteria) this;
        }

        public Criteria andGoodsCostIn(List<BigDecimal> values) {
            addCriterion("GOODS_COST in", values, "goodsCost");
            return (Criteria) this;
        }

        public Criteria andGoodsCostNotIn(List<BigDecimal> values) {
            addCriterion("GOODS_COST not in", values, "goodsCost");
            return (Criteria) this;
        }

        public Criteria andGoodsCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GOODS_COST between", value1, value2, "goodsCost");
            return (Criteria) this;
        }

        public Criteria andGoodsCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GOODS_COST not between", value1, value2, "goodsCost");
            return (Criteria) this;
        }

        public Criteria andGoodsIsNull() {
            addCriterion("GOODS is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIsNotNull() {
            addCriterion("GOODS is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsEqualTo(String value) {
            addCriterion("GOODS =", value, "goods");
            return (Criteria) this;
        }

        public Criteria andGoodsNotEqualTo(String value) {
            addCriterion("GOODS <>", value, "goods");
            return (Criteria) this;
        }

        public Criteria andGoodsGreaterThan(String value) {
            addCriterion("GOODS >", value, "goods");
            return (Criteria) this;
        }

        public Criteria andGoodsGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS >=", value, "goods");
            return (Criteria) this;
        }

        public Criteria andGoodsLessThan(String value) {
            addCriterion("GOODS <", value, "goods");
            return (Criteria) this;
        }

        public Criteria andGoodsLessThanOrEqualTo(String value) {
            addCriterion("GOODS <=", value, "goods");
            return (Criteria) this;
        }

        public Criteria andGoodsLike(String value) {
            addCriterion("GOODS like", value, "goods");
            return (Criteria) this;
        }

        public Criteria andGoodsNotLike(String value) {
            addCriterion("GOODS not like", value, "goods");
            return (Criteria) this;
        }

        public Criteria andGoodsIn(List<String> values) {
            addCriterion("GOODS in", values, "goods");
            return (Criteria) this;
        }

        public Criteria andGoodsNotIn(List<String> values) {
            addCriterion("GOODS not in", values, "goods");
            return (Criteria) this;
        }

        public Criteria andGoodsBetween(String value1, String value2) {
            addCriterion("GOODS between", value1, value2, "goods");
            return (Criteria) this;
        }

        public Criteria andGoodsNotBetween(String value1, String value2) {
            addCriterion("GOODS not between", value1, value2, "goods");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("NOTE is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("NOTE is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("NOTE =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("NOTE <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("NOTE >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("NOTE >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("NOTE <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("NOTE <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("NOTE like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("NOTE not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("NOTE in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("NOTE not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("NOTE between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("NOTE not between", value1, value2, "note");
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