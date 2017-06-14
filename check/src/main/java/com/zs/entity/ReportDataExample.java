package com.zs.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReportDataExample() {
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

        public Criteria andCountDateIsNull() {
            addCriterion("COUNT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCountDateIsNotNull() {
            addCriterion("COUNT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCountDateEqualTo(Date value) {
            addCriterion("COUNT_DATE =", value, "countDate");
            return (Criteria) this;
        }

        public Criteria andCountDateNotEqualTo(Date value) {
            addCriterion("COUNT_DATE <>", value, "countDate");
            return (Criteria) this;
        }

        public Criteria andCountDateGreaterThan(Date value) {
            addCriterion("COUNT_DATE >", value, "countDate");
            return (Criteria) this;
        }

        public Criteria andCountDateGreaterThanOrEqualTo(Date value) {
            addCriterion("COUNT_DATE >=", value, "countDate");
            return (Criteria) this;
        }

        public Criteria andCountDateLessThan(Date value) {
            addCriterion("COUNT_DATE <", value, "countDate");
            return (Criteria) this;
        }

        public Criteria andCountDateLessThanOrEqualTo(Date value) {
            addCriterion("COUNT_DATE <=", value, "countDate");
            return (Criteria) this;
        }

        public Criteria andCountDateIn(List<Date> values) {
            addCriterion("COUNT_DATE in", values, "countDate");
            return (Criteria) this;
        }

        public Criteria andCountDateNotIn(List<Date> values) {
            addCriterion("COUNT_DATE not in", values, "countDate");
            return (Criteria) this;
        }

        public Criteria andCountDateBetween(Date value1, Date value2) {
            addCriterion("COUNT_DATE between", value1, value2, "countDate");
            return (Criteria) this;
        }

        public Criteria andCountDateNotBetween(Date value1, Date value2) {
            addCriterion("COUNT_DATE not between", value1, value2, "countDate");
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

        public Criteria andCustomTypeIsNull() {
            addCriterion("CUSTOM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCustomTypeIsNotNull() {
            addCriterion("CUSTOM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCustomTypeEqualTo(String value) {
            addCriterion("CUSTOM_TYPE =", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeNotEqualTo(String value) {
            addCriterion("CUSTOM_TYPE <>", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeGreaterThan(String value) {
            addCriterion("CUSTOM_TYPE >", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOM_TYPE >=", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeLessThan(String value) {
            addCriterion("CUSTOM_TYPE <", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeLessThanOrEqualTo(String value) {
            addCriterion("CUSTOM_TYPE <=", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeLike(String value) {
            addCriterion("CUSTOM_TYPE like", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeNotLike(String value) {
            addCriterion("CUSTOM_TYPE not like", value, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeIn(List<String> values) {
            addCriterion("CUSTOM_TYPE in", values, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeNotIn(List<String> values) {
            addCriterion("CUSTOM_TYPE not in", values, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeBetween(String value1, String value2) {
            addCriterion("CUSTOM_TYPE between", value1, value2, "customType");
            return (Criteria) this;
        }

        public Criteria andCustomTypeNotBetween(String value1, String value2) {
            addCriterion("CUSTOM_TYPE not between", value1, value2, "customType");
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

        public Criteria andElectronicSheetIsNull() {
            addCriterion("ELECTRONIC_SHEET is null");
            return (Criteria) this;
        }

        public Criteria andElectronicSheetIsNotNull() {
            addCriterion("ELECTRONIC_SHEET is not null");
            return (Criteria) this;
        }

        public Criteria andElectronicSheetEqualTo(BigDecimal value) {
            addCriterion("ELECTRONIC_SHEET =", value, "electronicSheet");
            return (Criteria) this;
        }

        public Criteria andElectronicSheetNotEqualTo(BigDecimal value) {
            addCriterion("ELECTRONIC_SHEET <>", value, "electronicSheet");
            return (Criteria) this;
        }

        public Criteria andElectronicSheetGreaterThan(BigDecimal value) {
            addCriterion("ELECTRONIC_SHEET >", value, "electronicSheet");
            return (Criteria) this;
        }

        public Criteria andElectronicSheetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ELECTRONIC_SHEET >=", value, "electronicSheet");
            return (Criteria) this;
        }

        public Criteria andElectronicSheetLessThan(BigDecimal value) {
            addCriterion("ELECTRONIC_SHEET <", value, "electronicSheet");
            return (Criteria) this;
        }

        public Criteria andElectronicSheetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ELECTRONIC_SHEET <=", value, "electronicSheet");
            return (Criteria) this;
        }

        public Criteria andElectronicSheetIn(List<BigDecimal> values) {
            addCriterion("ELECTRONIC_SHEET in", values, "electronicSheet");
            return (Criteria) this;
        }

        public Criteria andElectronicSheetNotIn(List<BigDecimal> values) {
            addCriterion("ELECTRONIC_SHEET not in", values, "electronicSheet");
            return (Criteria) this;
        }

        public Criteria andElectronicSheetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ELECTRONIC_SHEET between", value1, value2, "electronicSheet");
            return (Criteria) this;
        }

        public Criteria andElectronicSheetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ELECTRONIC_SHEET not between", value1, value2, "electronicSheet");
            return (Criteria) this;
        }

        public Criteria andGenericSheetIsNull() {
            addCriterion("GENERIC_SHEET is null");
            return (Criteria) this;
        }

        public Criteria andGenericSheetIsNotNull() {
            addCriterion("GENERIC_SHEET is not null");
            return (Criteria) this;
        }

        public Criteria andGenericSheetEqualTo(BigDecimal value) {
            addCriterion("GENERIC_SHEET =", value, "genericSheet");
            return (Criteria) this;
        }

        public Criteria andGenericSheetNotEqualTo(BigDecimal value) {
            addCriterion("GENERIC_SHEET <>", value, "genericSheet");
            return (Criteria) this;
        }

        public Criteria andGenericSheetGreaterThan(BigDecimal value) {
            addCriterion("GENERIC_SHEET >", value, "genericSheet");
            return (Criteria) this;
        }

        public Criteria andGenericSheetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GENERIC_SHEET >=", value, "genericSheet");
            return (Criteria) this;
        }

        public Criteria andGenericSheetLessThan(BigDecimal value) {
            addCriterion("GENERIC_SHEET <", value, "genericSheet");
            return (Criteria) this;
        }

        public Criteria andGenericSheetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GENERIC_SHEET <=", value, "genericSheet");
            return (Criteria) this;
        }

        public Criteria andGenericSheetIn(List<BigDecimal> values) {
            addCriterion("GENERIC_SHEET in", values, "genericSheet");
            return (Criteria) this;
        }

        public Criteria andGenericSheetNotIn(List<BigDecimal> values) {
            addCriterion("GENERIC_SHEET not in", values, "genericSheet");
            return (Criteria) this;
        }

        public Criteria andGenericSheetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GENERIC_SHEET between", value1, value2, "genericSheet");
            return (Criteria) this;
        }

        public Criteria andGenericSheetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GENERIC_SHEET not between", value1, value2, "genericSheet");
            return (Criteria) this;
        }

        public Criteria andOtherSheetIsNull() {
            addCriterion("OTHER_SHEET is null");
            return (Criteria) this;
        }

        public Criteria andOtherSheetIsNotNull() {
            addCriterion("OTHER_SHEET is not null");
            return (Criteria) this;
        }

        public Criteria andOtherSheetEqualTo(BigDecimal value) {
            addCriterion("OTHER_SHEET =", value, "otherSheet");
            return (Criteria) this;
        }

        public Criteria andOtherSheetNotEqualTo(BigDecimal value) {
            addCriterion("OTHER_SHEET <>", value, "otherSheet");
            return (Criteria) this;
        }

        public Criteria andOtherSheetGreaterThan(BigDecimal value) {
            addCriterion("OTHER_SHEET >", value, "otherSheet");
            return (Criteria) this;
        }

        public Criteria andOtherSheetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OTHER_SHEET >=", value, "otherSheet");
            return (Criteria) this;
        }

        public Criteria andOtherSheetLessThan(BigDecimal value) {
            addCriterion("OTHER_SHEET <", value, "otherSheet");
            return (Criteria) this;
        }

        public Criteria andOtherSheetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OTHER_SHEET <=", value, "otherSheet");
            return (Criteria) this;
        }

        public Criteria andOtherSheetIn(List<BigDecimal> values) {
            addCriterion("OTHER_SHEET in", values, "otherSheet");
            return (Criteria) this;
        }

        public Criteria andOtherSheetNotIn(List<BigDecimal> values) {
            addCriterion("OTHER_SHEET not in", values, "otherSheet");
            return (Criteria) this;
        }

        public Criteria andOtherSheetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OTHER_SHEET between", value1, value2, "otherSheet");
            return (Criteria) this;
        }

        public Criteria andOtherSheetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OTHER_SHEET not between", value1, value2, "otherSheet");
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