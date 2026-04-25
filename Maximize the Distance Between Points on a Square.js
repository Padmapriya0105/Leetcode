var maxDistance = function(side, points, k) {
    let low = 1, high = 2 * side, ans = 0;

    function getManhattan(p1, p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    function canPlace(index, count, selected) {
        if (count === k) return true;
        if (index === points.length) return false;

        for (let i = index; i < points.length; i++) {
            let ok = true;
            for (let j = 0; j < selected.length; j++) {
                if (getManhattan(points[i], selected[j]) < currentMin) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                selected.push(points[i]);
                if (canPlace(i + 1, count + 1, selected)) return true;
                selected.pop();
            }
        }
        return false;
    }

    let currentMin = 0;
    while (low <= high) {
        let mid = Math.floor((low + high) / 2);
        currentMin = mid;
        if (canPlace(0, 0, [])) {
            ans = mid;
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return ans;
};
