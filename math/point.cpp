struct point {
    double x, y, z;
    point(double x, double y, double z = 1.) : x(x), y(y), z(z) {}

    // 마지막 선분을 1로 바꿈
    point projection()  return point(x/z, y/z);}

    // 외적
    point operator * (point & rhs) { return point ( y * rhs.z - z * rhs.y, z * rhs.x - x*rhs.z, x * rhs.y -y * rhs.x);}
};

// 두 점을 지나는 직선
point I = p1 * p2;

// 두직선의 교점
point p = I1 * I2;
if(p.z != 0) p = p.projection();