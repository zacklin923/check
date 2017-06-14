package com.zs.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReportMonthExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReportMonthExample() {
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

        public Criteria andCtmTypeIsNull() {
            addCriterion("CTM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCtmTypeIsNotNull() {
            addCriterion("CTM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCtmTypeEqualTo(String value) {
            addCriterion("CTM_TYPE =", value, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeNotEqualTo(String value) {
            addCriterion("CTM_TYPE <>", value, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeGreaterThan(String value) {
            addCriterion("CTM_TYPE >", value, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CTM_TYPE >=", value, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeLessThan(String value) {
            addCriterion("CTM_TYPE <", value, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeLessThanOrEqualTo(String value) {
            addCriterion("CTM_TYPE <=", value, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeLike(String value) {
            addCriterion("CTM_TYPE like", value, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeNotLike(String value) {
            addCriterion("CTM_TYPE not like", value, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeIn(List<String> values) {
            addCriterion("CTM_TYPE in", values, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeNotIn(List<String> values) {
            addCriterion("CTM_TYPE not in", values, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeBetween(String value1, String value2) {
            addCriterion("CTM_TYPE between", value1, value2, "ctmType");
            return (Criteria) this;
        }

        public Criteria andCtmTypeNotBetween(String value1, String value2) {
            addCriterion("CTM_TYPE not between", value1, value2, "ctmType");
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

        public Criteria andSliceAreaIsNull() {
            addCriterion("SLICE_AREA is null");
            return (Criteria) this;
        }

        public Criteria andSliceAreaIsNotNull() {
            addCriterion("SLICE_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andSliceAreaEqualTo(String value) {
            addCriterion("SLICE_AREA =", value, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaNotEqualTo(String value) {
            addCriterion("SLICE_AREA <>", value, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaGreaterThan(String value) {
            addCriterion("SLICE_AREA >", value, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaGreaterThanOrEqualTo(String value) {
            addCriterion("SLICE_AREA >=", value, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaLessThan(String value) {
            addCriterion("SLICE_AREA <", value, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaLessThanOrEqualTo(String value) {
            addCriterion("SLICE_AREA <=", value, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaLike(String value) {
            addCriterion("SLICE_AREA like", value, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaNotLike(String value) {
            addCriterion("SLICE_AREA not like", value, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaIn(List<String> values) {
            addCriterion("SLICE_AREA in", values, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaNotIn(List<String> values) {
            addCriterion("SLICE_AREA not in", values, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaBetween(String value1, String value2) {
            addCriterion("SLICE_AREA between", value1, value2, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andSliceAreaNotBetween(String value1, String value2) {
            addCriterion("SLICE_AREA not between", value1, value2, "sliceArea");
            return (Criteria) this;
        }

        public Criteria andFenBuIsNull() {
            addCriterion("FEN_BU is null");
            return (Criteria) this;
        }

        public Criteria andFenBuIsNotNull() {
            addCriterion("FEN_BU is not null");
            return (Criteria) this;
        }

        public Criteria andFenBuEqualTo(String value) {
            addCriterion("FEN_BU =", value, "fenBu");
            return (Criteria) this;
        }

        public Criteria andFenBuNotEqualTo(String value) {
            addCriterion("FEN_BU <>", value, "fenBu");
            return (Criteria) this;
        }

        public Criteria andFenBuGreaterThan(String value) {
            addCriterion("FEN_BU >", value, "fenBu");
            return (Criteria) this;
        }

        public Criteria andFenBuGreaterThanOrEqualTo(String value) {
            addCriterion("FEN_BU >=", value, "fenBu");
            return (Criteria) this;
        }

        public Criteria andFenBuLessThan(String value) {
            addCriterion("FEN_BU <", value, "fenBu");
            return (Criteria) this;
        }

        public Criteria andFenBuLessThanOrEqualTo(String value) {
            addCriterion("FEN_BU <=", value, "fenBu");
            return (Criteria) this;
        }

        public Criteria andFenBuLike(String value) {
            addCriterion("FEN_BU like", value, "fenBu");
            return (Criteria) this;
        }

        public Criteria andFenBuNotLike(String value) {
            addCriterion("FEN_BU not like", value, "fenBu");
            return (Criteria) this;
        }

        public Criteria andFenBuIn(List<String> values) {
            addCriterion("FEN_BU in", values, "fenBu");
            return (Criteria) this;
        }

        public Criteria andFenBuNotIn(List<String> values) {
            addCriterion("FEN_BU not in", values, "fenBu");
            return (Criteria) this;
        }

        public Criteria andFenBuBetween(String value1, String value2) {
            addCriterion("FEN_BU between", value1, value2, "fenBu");
            return (Criteria) this;
        }

        public Criteria andFenBuNotBetween(String value1, String value2) {
            addCriterion("FEN_BU not between", value1, value2, "fenBu");
            return (Criteria) this;
        }

        public Criteria andCountAllIsNull() {
            addCriterion("COUNT_ALL is null");
            return (Criteria) this;
        }

        public Criteria andCountAllIsNotNull() {
            addCriterion("COUNT_ALL is not null");
            return (Criteria) this;
        }

        public Criteria andCountAllEqualTo(BigDecimal value) {
            addCriterion("COUNT_ALL =", value, "countAll");
            return (Criteria) this;
        }

        public Criteria andCountAllNotEqualTo(BigDecimal value) {
            addCriterion("COUNT_ALL <>", value, "countAll");
            return (Criteria) this;
        }

        public Criteria andCountAllGreaterThan(BigDecimal value) {
            addCriterion("COUNT_ALL >", value, "countAll");
            return (Criteria) this;
        }

        public Criteria andCountAllGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_ALL >=", value, "countAll");
            return (Criteria) this;
        }

        public Criteria andCountAllLessThan(BigDecimal value) {
            addCriterion("COUNT_ALL <", value, "countAll");
            return (Criteria) this;
        }

        public Criteria andCountAllLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNT_ALL <=", value, "countAll");
            return (Criteria) this;
        }

        public Criteria andCountAllIn(List<BigDecimal> values) {
            addCriterion("COUNT_ALL in", values, "countAll");
            return (Criteria) this;
        }

        public Criteria andCountAllNotIn(List<BigDecimal> values) {
            addCriterion("COUNT_ALL not in", values, "countAll");
            return (Criteria) this;
        }

        public Criteria andCountAllBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_ALL between", value1, value2, "countAll");
            return (Criteria) this;
        }

        public Criteria andCountAllNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNT_ALL not between", value1, value2, "countAll");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(BigDecimal value) {
            addCriterion("FLAG =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(BigDecimal value) {
            addCriterion("FLAG <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(BigDecimal value) {
            addCriterion("FLAG >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FLAG >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(BigDecimal value) {
            addCriterion("FLAG <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FLAG <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<BigDecimal> values) {
            addCriterion("FLAG in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<BigDecimal> values) {
            addCriterion("FLAG not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FLAG between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FLAG not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andYearsIsNull() {
            addCriterion("YEARS is null");
            return (Criteria) this;
        }

        public Criteria andYearsIsNotNull() {
            addCriterion("YEARS is not null");
            return (Criteria) this;
        }

        public Criteria andYearsEqualTo(String value) {
            addCriterion("YEARS =", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsNotEqualTo(String value) {
            addCriterion("YEARS <>", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsGreaterThan(String value) {
            addCriterion("YEARS >", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsGreaterThanOrEqualTo(String value) {
            addCriterion("YEARS >=", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsLessThan(String value) {
            addCriterion("YEARS <", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsLessThanOrEqualTo(String value) {
            addCriterion("YEARS <=", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsLike(String value) {
            addCriterion("YEARS like", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsNotLike(String value) {
            addCriterion("YEARS not like", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsIn(List<String> values) {
            addCriterion("YEARS in", values, "years");
            return (Criteria) this;
        }

        public Criteria andYearsNotIn(List<String> values) {
            addCriterion("YEARS not in", values, "years");
            return (Criteria) this;
        }

        public Criteria andYearsBetween(String value1, String value2) {
            addCriterion("YEARS between", value1, value2, "years");
            return (Criteria) this;
        }

        public Criteria andYearsNotBetween(String value1, String value2) {
            addCriterion("YEARS not between", value1, value2, "years");
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