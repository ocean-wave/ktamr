var myData = {
	DataRangePicker: function(el, tp, options){
		if(!options){options = {}};
		// has daterangepicker or not
		var drp = $(el).data('daterangepicker');
		if (drp) {return};

		// options{minDate,maxDate,startDate,endDate,limitDays,format, cb_add:function(p_value)}
		var type = 'DateTime';
		var opts = {};
		var cb = function(start, end, label) {};
		// get value
		if(tp){type = tp};
		if(options.minDate){opts.minDate=options.minDate;};
		if(options.maxDate){opts.maxDate=options.maxDate;};
		if(options.startDate){opts.startDate=options.startDate;};
		if(options.endDate){opts.endDate=options.endDate;};
		if(options.format_start){opts.format_start=options.format_start;};
		if(options.format_end){opts.format_end=options.format_end;};
		if(options.limitDays){opts.dateLimit={days:options.limitDays};};
		// set opts       
		opts.timePickerSeconds = true;
		opts.timePicker12Hour = false;
		opts.timePickerIncrement = 1;

		opts.locale = {
		  fromLabel: '从',
		  toLabel: '到',
		  customRangeLabel: '自定义',
		  applyLabel: '确定',
		  cancelLabel: '取消',
		  daysOfWeek: ['日', '一', '二', '三', '四', '五','六'],
		  monthNames: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
		  firstDay: 1
		}
		opts.buttonClasses = ['btn btn-default'];
		opts.applyClass = 'btn-small btn-primary';
		opts.cancelClass = 'btn-small';
		opts.separator = ' ~ ';
		opts.opens = options.align||'left';

		if(type=='Date'){
		  opts.format = 'YYYY-MM-DD'; opts.singleDatePicker = true; opts.timePicker = false;
		}else if(type=='DateTime'){
		  opts.format = 'YYYY-MM-DD HH:mm:ss'; opts.singleDatePicker = true; opts.timePicker = true;
		}else if(type=='DateRange'){
		  opts.format = 'YYYY-MM-DD'; opts.singleDatePicker = false; opts.timePicker = false; 
		}else if(type=='DateTimeRange'){
		  opts.format = 'YYYY-MM-DD HH:mm:ss'; opts.singleDatePicker = false; opts.timePicker = true;
		}else if(type=='MonthRange'){
		  opts.format = 'YYYY-MM'; opts.singleDatePicker = false; opts.timePicker = false; 
		};
		if(type=='Date' || type=='DateTime'){
		  cb = function(start, end, label) {
			if (options.cb_add) {options.cb_add(start.format(opts.format))};
		  };
		}else if(type=='DateRange' || type=="DateTimeRange" || type=="MonthRange"){
		  opts.ranges = {
			//'今天': [moment().format(opts.format_start||opts.format), moment().format(opts.format_end||opts.format)],
			//'昨天': [moment().subtract(1, 'days').format(opts.format_start||opts.format), moment().subtract(1, 'days').format(opts.format_end||opts.format)],
			//'最近一周': [moment().subtract(6, 'days').format(opts.format_start||opts.format), moment().format(opts.format_end||opts.format)],
			//'最近30天': [moment().subtract(29, 'days').format(opts.format_start||opts.format), moment().format(opts.format_end||opts.format)],
			'上个月': [moment().subtract(1, 'month').startOf('month').format(opts.format_start||opts.format), moment().subtract(1, 'month').endOf('month').format(opts.format_end||opts.format)],
			'本月': [moment().startOf('month').format(opts.format_start||opts.format), moment().endOf('month').format(opts.format_end||opts.format)]
		  };
		  
		  if (el.tagName.toLowerCase()=='input') {
			cb = function(start, end, label) {
			  var value = start.format(opts.format||opts.format_start) + '~' + end.format(opts.format||opts.format_end);
			  $(el).val(value);
			  if (options.cb_add) {options.cb_add(value)};
			}
		  }else{
			cb = function(start, end, label) {
			  var value = start.format(opts.format||opts.format_start) + '~' + end.format(opts.format||opts.format_end);
			  $(el).find('span').html(value);
			  if (options.cb_add) {options.cb_add(value)};
			}
		  };
		}

		$(el).daterangepicker(opts, cb);
		$(el).data('daterangepicker').show();		
	}
};