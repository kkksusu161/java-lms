package nextstep.courses.domain;

import java.util.Objects;

public class SessionPrice {

    private final long salePrice;

    public SessionPrice(final long salePrice) {
        if (isLessThanTo(salePrice)) {
            throw new IllegalArgumentException("판매가가 올바르지 않습니다.");
        }
        this.salePrice = salePrice;
    }

    public long getSalePrice() {
        return salePrice;
    }

    public boolean isLessThanOrEqualTo(long salePrice) {
        return this.salePrice < salePrice;
    }

    public boolean isLessThanTo(long salePrice) {
        return salePrice < 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionPrice that = (SessionPrice) o;
        return salePrice == that.salePrice;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(salePrice);
    }

}
