var makeSVG = function(tag, attrs) {
    var el= document.createElementNS('http://www.w3.org/2000/svg', tag);
    for (var k in attrs)
        el.setAttribute(k, attrs[k]);
    return el;
}

var createTile = function(x, y, radius) {
	var centreX = x + radius,
		centreY = y + radius,
		sides = 6,
		points = [];

	for (var i = 0.5; i < sides; i++) {
		points.push([
			centreX + radius * Math.cos((i * 2 * Math.PI) / sides),
			centreY + radius * Math.sin((i * 2 * Math.PI) / sides),
		].join(","));
	}

	return makeSVG("polygon", {
		"points": points.join(" "),
		"style": "stroke:#000000; fill:#eeeeee;",
	});
};

var createLabel = function(text, x, y) {
	var a = makeSVG("text", {
		'x': x,
		'y': y,
		'font-family': "sans-serif",
		'font-size': "24px",
		'fill': "black",
		'text-anchor': "middle",
		'dominant-baseline': "middle",
	});
	a.innerHTML = text;

	return a;
};

var createLine = function(svg, x, y, n, size, hSize) {
	for (var i=0; i<n; i++) {
		svg.append(createTile(x + hSize * i, y, size / 2));
		svg.append(createLabel(numbers.pop(), x + hSize * i + size / 2, y + size / 2));
	}
};
 
var board = $("#boardgame"),
	size = board.width(),

	svg =  $(makeSVG("svg", {
		'height': size,
		'width': size,
	})),
	tileSize = (size / 5),
	hSize = tileSize * Math.cos((0.5 * 2 * Math.PI) / 6),
	vSize = tileSize * Math.sin((0.5 * 2 * Math.PI) / 6) * 1.5,
	numbers = [3, 4, 5, 2, 17, 16, 6, 1, 18, 19, 15, 7, 12, 13, 14, 8, 11, 10, 9]
	;


board.append(svg);
createLine(svg, hSize * 1.0, vSize * 0, 3, tileSize, hSize);
createLine(svg, hSize * 0.5, vSize * 1, 4, tileSize, hSize);
createLine(svg, hSize * 0.0, vSize * 2, 5, tileSize, hSize);
createLine(svg, hSize * 0.5, vSize * 3, 4, tileSize, hSize);
createLine(svg, hSize * 1.0, vSize * 4, 3, tileSize, hSize);
