package com.zs.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZmReturnDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZmReturnDataExample() {
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

        public Criteria andCourierNumberEqualTo(String value) {
            addCriterion("COURIER_NUMBER =", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberNotEqualTo(String value) {
            addCriterion("COURIER_NUMBER <>", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberGreaterThan(String value) {
            addCriterion("COURIER_NUMBER >", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberGreaterThanOrEqualTo(String value) {
            addCriterion("COURIER_NUMBER >=", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberLessThan(String value) {
            addCriterion("COURIER_NUMBER <", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberLessThanOrEqualTo(String value) {
            addCriterion("COURIER_NUMBER <=", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberLike(String value) {
            addCriterion("COURIER_NUMBER like", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberNotLike(String value) {
            addCriterion("COURIER_NUMBER not like", value, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberIn(List<String> values) {
            addCriterion("COURIER_NUMBER in", values, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberNotIn(List<String> values) {
            addCriterion("COURIER_NUMBER not in", values, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberBetween(String value1, String value2) {
            addCriterion("COURIER_NUMBER between", value1, value2, "courierNumber");
            return (Criteria) this;
        }

        public Criteria andCourierNumberNotBetween(String value1, String value2) {
            addCriterion("COURIER_NUMBER not between", value1, value2, "courierNumber");
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

        public Criteria andFenbuIsNull() {
            addCriterion("FENBU is null");
            return (Criteria) this;
        }

        public Criteria andFenbuIsNotNull() {
            addCriterion("FENBU is not null");
            return (Criteria) this;
        }

        public Criteria andFenbuEqualTo(String value) {
            addCriterion("FENBU =", value, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuNotEqualTo(String value) {
            addCriterion("FENBU <>", value, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuGreaterThan(String value) {
            addCriterion("FENBU >", value, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuGreaterThanOrEqualTo(String value) {
            addCriterion("FENBU >=", value, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuLessThan(String value) {
            addCriterion("FENBU <", value, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuLessThanOrEqualTo(String value) {
            addCriterion("FENBU <=", value, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuLike(String value) {
            addCriterion("FENBU like", value, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuNotLike(String value) {
            addCriterion("FENBU not like", value, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuIn(List<String> values) {
            addCriterion("FENBU in", values, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuNotIn(List<String> values) {
            addCriterion("FENBU not in", values, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuBetween(String value1, String value2) {
            addCriterion("FENBU between", value1, value2, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFenbuNotBetween(String value1, String value2) {
            addCriterion("FENBU not between", value1, value2, "fenbu");
            return (Criteria) this;
        }

        public Criteria andFbdAreaIsNull() {
            addCriterion("FBD_AREA is null");
            return (Criteria) this;
        }

        public Criteria andFbdAreaIsNotNull() {
            addCriterion("FBD_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andFbdAreaEqualTo(String value) {
            addCriterion("FBD_AREA =", value, "fbdArea");
            return (Criteria) this;
        }

        public Criteria andFbdAreaNotEqualTo(String value) {
            addCriterion("FBD_AREA <>", value, "fbdArea");
            return (Criteria) this;
        }

        public Criteria andFbdAreaGreaterThan(String value) {
            addCriterion("FBD_AREA >", value, "fbdArea");
            return (Criteria) this;
        }

        public Criteria andFbdAreaGreaterThanOrEqualTo(String value) {
            addCriterion("FBD_AREA >=", value, "fbdArea");
            return (Criteria) this;
        }

        public Criteria andFbdAreaLessThan(String value) {
            addCriterion("FBD_AREA <", value, "fbdArea");
            return (Criteria) this;
        }

        public Criteria andFbdAreaLessThanOrEqualTo(String value) {
            addCriterion("FBD_AREA <=", value, "fbdArea");
            return (Criteria) this;
        }

        public Criteria andFbdAreaLike(String value) {
            addCriterion("FBD_AREA like", value, "fbdArea");
            return (Criteria) this;
        }

        public Criteria andFbdAreaNotLike(String value) {
            addCriterion("FBD_AREA not like", value, "fbdArea");
            return (Criteria) this;
        }

        public Criteria andFbdAreaIn(List<String> values) {
            addCriterion("FBD_AREA in", values, "fbdArea");
            return (Criteria) this;
        }

        public Criteria andFbdAreaNotIn(List<String> values) {
            addCriterion("FBD_AREA not in", values, "fbdArea");
            return (Criteria) this;
        }

        public Criteria andFbdAreaBetween(String value1, String value2) {
            addCriterion("FBD_AREA between", value1, value2, "fbdArea");
            return (Criteria) this;
        }

        public Criteria andFbdAreaNotBetween(String value1, String value2) {
            addCriterion("FBD_AREA not between", value1, value2, "fbdArea");
            return (Criteria) this;
        }

        public Criteria andShopNumberIsNull() {
            addCriterion("SHOP_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andShopNumberIsNotNull() {
            addCriterion("SHOP_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andShopNumberEqualTo(String value) {
            addCriterion("SHOP_NUMBER =", value, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberNotEqualTo(String value) {
            addCriterion("SHOP_NUMBER <>", value, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberGreaterThan(String value) {
            addCriterion("SHOP_NUMBER >", value, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberGreaterThanOrEqualTo(String value) {
            addCriterion("SHOP_NUMBER >=", value, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberLessThan(String value) {
            addCriterion("SHOP_NUMBER <", value, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberLessThanOrEqualTo(String value) {
            addCriterion("SHOP_NUMBER <=", value, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberLike(String value) {
            addCriterion("SHOP_NUMBER like", value, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberNotLike(String value) {
            addCriterion("SHOP_NUMBER not like", value, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberIn(List<String> values) {
            addCriterion("SHOP_NUMBER in", values, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberNotIn(List<String> values) {
            addCriterion("SHOP_NUMBER not in", values, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberBetween(String value1, String value2) {
            addCriterion("SHOP_NUMBER between", value1, value2, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberNotBetween(String value1, String value2) {
            addCriterion("SHOP_NUMBER not between", value1, value2, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddresseeIsNull() {
            addCriterion("ADDRESSEE is null");
            return (Criteria) this;
        }

        public Criteria andAddresseeIsNotNull() {
            addCriterion("ADDRESSEE is not null");
            return (Criteria) this;
        }

        public Criteria andAddresseeEqualTo(String value) {
            addCriterion("ADDRESSEE =", value, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeNotEqualTo(String value) {
            addCriterion("ADDRESSEE <>", value, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeGreaterThan(String value) {
            addCriterion("ADDRESSEE >", value, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESSEE >=", value, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeLessThan(String value) {
            addCriterion("ADDRESSEE <", value, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeLessThanOrEqualTo(String value) {
            addCriterion("ADDRESSEE <=", value, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeLike(String value) {
            addCriterion("ADDRESSEE like", value, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeNotLike(String value) {
            addCriterion("ADDRESSEE not like", value, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeIn(List<String> values) {
            addCriterion("ADDRESSEE in", values, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeNotIn(List<String> values) {
            addCriterion("ADDRESSEE not in", values, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeBetween(String value1, String value2) {
            addCriterion("ADDRESSEE between", value1, value2, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeNotBetween(String value1, String value2) {
            addCriterion("ADDRESSEE not between", value1, value2, "addressee");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
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

        public Criteria andWeightIsNull() {
            addCriterion("WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("WEIGHT =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("WEIGHT <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("WEIGHT >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WEIGHT >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("WEIGHT <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WEIGHT <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("WEIGHT in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("WEIGHT not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WEIGHT between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WEIGHT not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andFeeIsNull() {
            addCriterion("FEE is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("FEE is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(BigDecimal value) {
            addCriterion("FEE =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(BigDecimal value) {
            addCriterion("FEE <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(BigDecimal value) {
            addCriterion("FEE >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(BigDecimal value) {
            addCriterion("FEE <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<BigDecimal> values) {
            addCriterion("FEE in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<BigDecimal> values) {
            addCriterion("FEE not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE not between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyIsNull() {
            addCriterion("COURIER_COMPANY is null");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyIsNotNull() {
            addCriterion("COURIER_COMPANY is not null");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyEqualTo(String value) {
            addCriterion("COURIER_COMPANY =", value, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyNotEqualTo(String value) {
            addCriterion("COURIER_COMPANY <>", value, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyGreaterThan(String value) {
            addCriterion("COURIER_COMPANY >", value, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("COURIER_COMPANY >=", value, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyLessThan(String value) {
            addCriterion("COURIER_COMPANY <", value, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyLessThanOrEqualTo(String value) {
            addCriterion("COURIER_COMPANY <=", value, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyLike(String value) {
            addCriterion("COURIER_COMPANY like", value, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyNotLike(String value) {
            addCriterion("COURIER_COMPANY not like", value, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyIn(List<String> values) {
            addCriterion("COURIER_COMPANY in", values, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyNotIn(List<String> values) {
            addCriterion("COURIER_COMPANY not in", values, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyBetween(String value1, String value2) {
            addCriterion("COURIER_COMPANY between", value1, value2, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyNotBetween(String value1, String value2) {
            addCriterion("COURIER_COMPANY not between", value1, value2, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNull() {
            addCriterion("ORDER_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("ORDER_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(String value) {
            addCriterion("ORDER_NUMBER =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(String value) {
            addCriterion("ORDER_NUMBER <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(String value) {
            addCriterion("ORDER_NUMBER >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_NUMBER >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(String value) {
            addCriterion("ORDER_NUMBER <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("ORDER_NUMBER <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLike(String value) {
            addCriterion("ORDER_NUMBER like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotLike(String value) {
            addCriterion("ORDER_NUMBER not like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<String> values) {
            addCriterion("ORDER_NUMBER in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<String> values) {
            addCriterion("ORDER_NUMBER not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(String value1, String value2) {
            addCriterion("ORDER_NUMBER between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(String value1, String value2) {
            addCriterion("ORDER_NUMBER not between", value1, value2, "orderNumber");
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

        public Criteria andCourierStateIsNull() {
            addCriterion("COURIER_STATE is null");
            return (Criteria) this;
        }

        public Criteria andCourierStateIsNotNull() {
            addCriterion("COURIER_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andCourierStateEqualTo(String value) {
            addCriterion("COURIER_STATE =", value, "courierState");
            return (Criteria) this;
        }

        public Criteria andCourierStateNotEqualTo(String value) {
            addCriterion("COURIER_STATE <>", value, "courierState");
            return (Criteria) this;
        }

        public Criteria andCourierStateGreaterThan(String value) {
            addCriterion("COURIER_STATE >", value, "courierState");
            return (Criteria) this;
        }

        public Criteria andCourierStateGreaterThanOrEqualTo(String value) {
            addCriterion("COURIER_STATE >=", value, "courierState");
            return (Criteria) this;
        }

        public Criteria andCourierStateLessThan(String value) {
            addCriterion("COURIER_STATE <", value, "courierState");
            return (Criteria) this;
        }

        public Criteria andCourierStateLessThanOrEqualTo(String value) {
            addCriterion("COURIER_STATE <=", value, "courierState");
            return (Criteria) this;
        }

        public Criteria andCourierStateLike(String value) {
            addCriterion("COURIER_STATE like", value, "courierState");
            return (Criteria) this;
        }

        public Criteria andCourierStateNotLike(String value) {
            addCriterion("COURIER_STATE not like", value, "courierState");
            return (Criteria) this;
        }

        public Criteria andCourierStateIn(List<String> values) {
            addCriterion("COURIER_STATE in", values, "courierState");
            return (Criteria) this;
        }

        public Criteria andCourierStateNotIn(List<String> values) {
            addCriterion("COURIER_STATE not in", values, "courierState");
            return (Criteria) this;
        }

        public Criteria andCourierStateBetween(String value1, String value2) {
            addCriterion("COURIER_STATE between", value1, value2, "courierState");
            return (Criteria) this;
        }

        public Criteria andCourierStateNotBetween(String value1, String value2) {
            addCriterion("COURIER_STATE not between", value1, value2, "courierState");
            return (Criteria) this;
        }

        public Criteria andTimeOutIsNull() {
            addCriterion("TIME_OUT is null");
            return (Criteria) this;
        }

        public Criteria andTimeOutIsNotNull() {
            addCriterion("TIME_OUT is not null");
            return (Criteria) this;
        }

        public Criteria andTimeOutEqualTo(Date value) {
            addCriterion("TIME_OUT =", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutNotEqualTo(Date value) {
            addCriterion("TIME_OUT <>", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutGreaterThan(Date value) {
            addCriterion("TIME_OUT >", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutGreaterThanOrEqualTo(Date value) {
            addCriterion("TIME_OUT >=", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutLessThan(Date value) {
            addCriterion("TIME_OUT <", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutLessThanOrEqualTo(Date value) {
            addCriterion("TIME_OUT <=", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutIn(List<Date> values) {
            addCriterion("TIME_OUT in", values, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutNotIn(List<Date> values) {
            addCriterion("TIME_OUT not in", values, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutBetween(Date value1, Date value2) {
            addCriterion("TIME_OUT between", value1, value2, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutNotBetween(Date value1, Date value2) {
            addCriterion("TIME_OUT not between", value1, value2, "timeOut");
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

        public Criteria andSignPortIsNull() {
            addCriterion("SIGN_PORT is null");
            return (Criteria) this;
        }

        public Criteria andSignPortIsNotNull() {
            addCriterion("SIGN_PORT is not null");
            return (Criteria) this;
        }

        public Criteria andSignPortEqualTo(String value) {
            addCriterion("SIGN_PORT =", value, "signPort");
            return (Criteria) this;
        }

        public Criteria andSignPortNotEqualTo(String value) {
            addCriterion("SIGN_PORT <>", value, "signPort");
            return (Criteria) this;
        }

        public Criteria andSignPortGreaterThan(String value) {
            addCriterion("SIGN_PORT >", value, "signPort");
            return (Criteria) this;
        }

        public Criteria andSignPortGreaterThanOrEqualTo(String value) {
            addCriterion("SIGN_PORT >=", value, "signPort");
            return (Criteria) this;
        }

        public Criteria andSignPortLessThan(String value) {
            addCriterion("SIGN_PORT <", value, "signPort");
            return (Criteria) this;
        }

        public Criteria andSignPortLessThanOrEqualTo(String value) {
            addCriterion("SIGN_PORT <=", value, "signPort");
            return (Criteria) this;
        }

        public Criteria andSignPortLike(String value) {
            addCriterion("SIGN_PORT like", value, "signPort");
            return (Criteria) this;
        }

        public Criteria andSignPortNotLike(String value) {
            addCriterion("SIGN_PORT not like", value, "signPort");
            return (Criteria) this;
        }

        public Criteria andSignPortIn(List<String> values) {
            addCriterion("SIGN_PORT in", values, "signPort");
            return (Criteria) this;
        }

        public Criteria andSignPortNotIn(List<String> values) {
            addCriterion("SIGN_PORT not in", values, "signPort");
            return (Criteria) this;
        }

        public Criteria andSignPortBetween(String value1, String value2) {
            addCriterion("SIGN_PORT between", value1, value2, "signPort");
            return (Criteria) this;
        }

        public Criteria andSignPortNotBetween(String value1, String value2) {
            addCriterion("SIGN_PORT not between", value1, value2, "signPort");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateManIsNull() {
            addCriterion("UPDATE_MAN is null");
            return (Criteria) this;
        }

        public Criteria andUpdateManIsNotNull() {
            addCriterion("UPDATE_MAN is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateManEqualTo(String value) {
            addCriterion("UPDATE_MAN =", value, "updateMan");
            return (Criteria) this;
        }

        public Criteria andUpdateManNotEqualTo(String value) {
            addCriterion("UPDATE_MAN <>", value, "updateMan");
            return (Criteria) this;
        }

        public Criteria andUpdateManGreaterThan(String value) {
            addCriterion("UPDATE_MAN >", value, "updateMan");
            return (Criteria) this;
        }

        public Criteria andUpdateManGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_MAN >=", value, "updateMan");
            return (Criteria) this;
        }

        public Criteria andUpdateManLessThan(String value) {
            addCriterion("UPDATE_MAN <", value, "updateMan");
            return (Criteria) this;
        }

        public Criteria andUpdateManLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_MAN <=", value, "updateMan");
            return (Criteria) this;
        }

        public Criteria andUpdateManLike(String value) {
            addCriterion("UPDATE_MAN like", value, "updateMan");
            return (Criteria) this;
        }

        public Criteria andUpdateManNotLike(String value) {
            addCriterion("UPDATE_MAN not like", value, "updateMan");
            return (Criteria) this;
        }

        public Criteria andUpdateManIn(List<String> values) {
            addCriterion("UPDATE_MAN in", values, "updateMan");
            return (Criteria) this;
        }

        public Criteria andUpdateManNotIn(List<String> values) {
            addCriterion("UPDATE_MAN not in", values, "updateMan");
            return (Criteria) this;
        }

        public Criteria andUpdateManBetween(String value1, String value2) {
            addCriterion("UPDATE_MAN between", value1, value2, "updateMan");
            return (Criteria) this;
        }

        public Criteria andUpdateManNotBetween(String value1, String value2) {
            addCriterion("UPDATE_MAN not between", value1, value2, "updateMan");
            return (Criteria) this;
        }

        public Criteria andSendDateIsNull() {
            addCriterion("SEND_DATE is null");
            return (Criteria) this;
        }

        public Criteria andSendDateIsNotNull() {
            addCriterion("SEND_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andSendDateEqualTo(Date value) {
            addCriterion("SEND_DATE =", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateNotEqualTo(Date value) {
            addCriterion("SEND_DATE <>", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateGreaterThan(Date value) {
            addCriterion("SEND_DATE >", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateGreaterThanOrEqualTo(Date value) {
            addCriterion("SEND_DATE >=", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateLessThan(Date value) {
            addCriterion("SEND_DATE <", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateLessThanOrEqualTo(Date value) {
            addCriterion("SEND_DATE <=", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateIn(List<Date> values) {
            addCriterion("SEND_DATE in", values, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateNotIn(List<Date> values) {
            addCriterion("SEND_DATE not in", values, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateBetween(Date value1, Date value2) {
            addCriterion("SEND_DATE between", value1, value2, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateNotBetween(Date value1, Date value2) {
            addCriterion("SEND_DATE not between", value1, value2, "sendDate");
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